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
        StringBuffer sourceConnectionString = new StringBuffer();
        StringBuffer targetConnectionString = new StringBuffer();


        // create connection to source and target and then execute test in separate thread
        // after run finishes then record values into Run and store to database

        if (source.getDriverClassName().equals("com.mysql.jdbc.Driver")) {
            sourceConnectionString.append("jdbc:mysql://")
                    .append(source.getServerName())
                    .append(":")
                    .append(source.getPortNumber())
                    .append("/")
                    .append(source.getDatabaseName());
        }


        if (source.getDriverClassName().equals("oracle.jdbc.OracleDriver")) {
            sourceConnectionString.append("jdbc:oracle:thin:@")
                    .append(source.getServerName())
                    .append(":")
                    .append(source.getPortNumber())
                    .append(":")
                    .append(source.getDatabaseName());
        }

        Connection sourceConn = DriverManager.getConnection(
                sourceConnectionString.toString(),
                source.getUser(),
                source.getPassword());

        Connection targetConn = DriverManager.getConnection(
                targetConnectionString.toString(),
                target.getUser(),
                target.getPassword());

        //thread.start();


        run.setCas(new Timestamp(System.currentTimeMillis()));
        run.setStart(new Timestamp(System.currentTimeMillis()));

        // thread start


        sourceConn.close();
        targetConn.close();

        throw new NotYetImplementedException("runTest");
    }


}
