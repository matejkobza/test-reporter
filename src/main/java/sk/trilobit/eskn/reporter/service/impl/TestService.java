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

        String URLsource = "jdbc:" + source.getDriverClassName() + "://" + source.getServerName() +
                            ":" + source.getPortNumber() + "/" + source.getDatabaseName();
        String USERsource = source.getUser();
        String PASSsource = source.getPassword();
        Connection connsource = DriverManager.getConnection(URLsource,USERsource,PASSsource);

        String URLtarget = "jdbc:" + target.getDriverClassName() + "://" + target.getServerName() +
                            ":" + target.getPortNumber() + "/" + target.getDatabaseName();
        String USERtarget = target.getUser();
        String PASStarget = target.getPassword();
        Connection conntarget = DriverManager.getConnection(URLtarget,USERtarget,PASStarget);


        thread.start();


        //connsource.close();
        //conntarget.close();

        throw new NotYetImplementedException("runTest");
    }

}
