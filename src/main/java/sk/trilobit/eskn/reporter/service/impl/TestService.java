package sk.trilobit.eskn.reporter.service.impl;

import lombok.ToString;
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
        StringBuffer URLsource = new StringBuffer();
        StringBuffer URLtarget = new StringBuffer();


        // create connection to source and target and then execute test in separate thread
        // after run finishes then record values into Run and store to database

        if(source.getDriverClassName().equals( "com.mysql.jdbc.Driver" ))
        {
            URLsource.append("jdbc:mysql://");
            URLsource.append(source.getServerName());
            URLsource.append(":");
            URLsource.append(source.getPortNumber());
            URLsource.append("/");
            URLsource.append(source.getDatabaseName());
        }


        if(source.getDriverClassName().equals( "oracle.jdbc.OracleDriver" ))
        {
            URLsource.append("jdbc:oracle:thin:@");
            URLsource.append(source.getServerName());
            URLsource.append(":");
            URLsource.append(source.getPortNumber());
            URLsource.append(":");
            URLsource.append(source.getDatabaseName());
        }

        String USERsource = source.getUser();
        String PASSsource = source.getPassword();
        Connection connsource = DriverManager.getConnection(URLsource.toString(),USERsource,PASSsource);


        if(source.getDriverClassName().equals( "com.mysql.jdbc.Driver" ))
        {
            URLtarget.append("jdbc:mysql://");
            URLtarget.append(source.getServerName());
            URLtarget.append(":");
            URLtarget.append(source.getPortNumber());
            URLtarget.append("/");
            URLtarget.append(source.getDatabaseName());
        }

        if(source.getDriverClassName().equals( "oracle.jdbc.OracleDriver" ))
        {
            URLtarget.append("jdbc:oracle:thin:@");
            URLtarget.append(source.getServerName());
            URLtarget.append(":");
            URLtarget.append(source.getPortNumber());
            URLtarget.append(":");
            URLtarget.append(source.getDatabaseName());
        }

        String USERtarget = target.getUser();
        String PASStarget = target.getPassword();
        Connection conntarget = DriverManager.getConnection(URLtarget.toString(),USERtarget,PASStarget);




        //thread.start();


        //connsource.close();
        //conntarget.close();

        throw new NotYetImplementedException("runTest");
    }


}
