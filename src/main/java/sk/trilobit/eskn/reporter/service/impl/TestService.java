package sk.trilobit.eskn.reporter.service.impl;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Service;
import sk.trilobit.eskn.reporter.entity.DataSource;
import sk.trilobit.eskn.reporter.entity.Run;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.RunRepository;
import sk.trilobit.eskn.reporter.repository.TestRepository;
import sk.trilobit.eskn.reporter.service.ITestService;

import javax.inject.Inject;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Timestamp;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 02.01.16
 * Time: 12:48
 */
@Service
public class TestService implements ITestService {

    @Inject
    private TestRepository testRepository;

    @Inject
    private RunRepository runRepository;

    public boolean runTest(Long testId) throws SQLException {
        Test test = testRepository.findOne(testId);

        DataSource source = test.getSource();
        DataSource target = test.getTarget();

        Run run = new Run();
        Thread thread = new Thread();



        // create connection to source and target and then execute test in separate thread
        // after run finishes then record values into Run and store to database

        Connection sourceConn = DriverManager.getConnection(
                connection(source),
                source.getUser(),
                source.getPassword());

        Connection targetConn = DriverManager.getConnection(
                connection(target),
                target.getUser(),
                target.getPassword());



        run.setCas(new Timestamp(System.currentTimeMillis()));
        run.setStart(new Timestamp(System.currentTimeMillis()));

        // thread start


        sourceConn.close();
        targetConn.close();

        throw new NotYetImplementedException("runTest");
    }

    public String connection(DataSource dataSource)
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


}
