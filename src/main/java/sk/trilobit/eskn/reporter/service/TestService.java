package sk.trilobit.eskn.reporter.service;

import org.hibernate.cfg.NotYetImplementedException;
import org.springframework.stereotype.Service;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.RunRepository;
import sk.trilobit.eskn.reporter.repository.TestRepository;

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

    private Connection getOracleConnection() throws ClassNotFoundException, SQLException {
        Class.forName("oracle.jdbc.driver.OracleDriver");

        return DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:mkyong", "username", "password");
    }

    private Connection getMySQLConnection() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");

        return DriverManager.getConnection("jdbc:mysql://localhost:3306/dbname", "username", "password");
    }

    private void closeConnection(Connection connection) throws SQLException {
        connection.close();
    }

    public boolean runTest(Long testId) {
        Test test = testRepository.findOne(testId);

        // getSourceConnection, getTargetConnection

        throw new NotYetImplementedException();
    }

}
