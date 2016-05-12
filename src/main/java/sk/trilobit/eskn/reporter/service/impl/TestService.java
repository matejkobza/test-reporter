package sk.trilobit.eskn.reporter.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.jexl3.JexlBuilder;
import org.apache.commons.jexl3.JexlEngine;
import org.apache.commons.jexl3.JexlExpression;
import org.apache.commons.jexl3.MapContext;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import sk.trilobit.eskn.reporter.entity.DataSource;
import sk.trilobit.eskn.reporter.entity.Run;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.RunRepository;
import sk.trilobit.eskn.reporter.repository.TestRepository;
import sk.trilobit.eskn.reporter.service.ITestService;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 02.01.16
 * Time: 12:48
 */
@Service
@Slf4j
public class TestService implements ITestService {

    @Inject
    private TestRepository testRepository;

    @Inject
    private RunRepository runRepository;

    @Transactional
    public boolean runTest(Long testId) {
        Test test = testRepository.findOne(testId);

        DataSource source = test.getSource();
        DataSource target = test.getTarget();

        Run run = new Run();
        run.setTest(test);



        // create connection to source and target and then execute test in separate thread
        // after run finishes then record values into Run and store to database

        Boolean result = false;
        try {
            Connection sourceConn = DriverManager.getConnection(
                    this.getConnectionString(source),
                    source.getUser(),
                    source.getPassword());

            Connection targetConn = DriverManager.getConnection(
                    this.getConnectionString(target),
                    target.getUser(),
                    target.getPassword());


            run.setCas(new Timestamp(System.currentTimeMillis()));
            run.setStart(new Timestamp(System.currentTimeMillis()));

            // thread start
            Statement statementSource = sourceConn.createStatement(); // create statement
            ResultSet rsSource = statementSource.executeQuery(test.getSourceSql()); // execute query and get resultset from database
            rsSource.next();// move cursor to first object
            Object resultSource = rsSource.getObject(1); // here we dont know what came back from DB so we cant use anything else than object

            // do the same for target
            Statement statementTarget = targetConn.createStatement();
            ResultSet rsTarget = statementTarget.executeQuery(test.getTargetSql());
            rsTarget.next();
            Object resultTarget = rsTarget.getObject(1);

            result = cond(resultSource, resultTarget, test.getCond());

            run.setSrc_result((String) resultSource);
            run.setTrg_result((String) resultTarget);

            sourceConn.close();
            targetConn.close();
        } catch (SQLException ex) {
            log.error("Unable to perform test run", ex);
            result = false;
        } finally {
            run.setStatus(result.compareTo(Boolean.TRUE));
            run.setEnd(new Timestamp(System.currentTimeMillis()));

            runRepository.save(run);
            return result;
        }
    }

    private String getConnectionString(DataSource dataSource)
    {
        StringBuffer connectionString = new StringBuffer();

        if (dataSource.getDriverClassName().equals("com.mysql.jdbc.Driver")) {
            connectionString.append("jdbc:mysql://")
                    .append(dataSource.getServerName())
                    .append(":")

                    .append(dataSource.getPortNumber())
                    .append("/")
                    .append(dataSource.getDatabaseName());
        }


        if (dataSource.getDriverClassName().equals("oracle.jdbc.OracleDriver")) {
            connectionString.append("jdbc:oracle:thin:@")
                    .append(dataSource.getServerName())
                    .append(":")
                    .append(dataSource.getPortNumber())
                    .append(":")
                    .append(dataSource.getDatabaseName());
        }

        return connectionString.toString();
    }

    private Boolean cond(Object source, Object target, String compareSign) throws Exception {
        // here compares the result with library provided in chat
        String expression = source + " " + compareSign + " " + target;

        // Create or retrieve an engine
        JexlEngine jexl = new JexlBuilder().create();

        // Create an expression
        JexlExpression e = jexl.createExpression(expression);

        // Create a context and add data

        // Now evaluate the expression, getting the result
        Object o = e.evaluate(new MapContext());
        // use it here and return result overloaded with Boolean
        if (o instanceof Boolean) {
            return expression.isEmpty();
        } else {
            throw new Exception(o.toString());
        }
    }


}
