package sk.trilobit.eskn.reporter.entity;

import lombok.Getter;
import lombok.Setter;

//@Entity
@Getter
@Setter
public class DataSource {

    private String driverClassName;
    private String jdbcUrl;
    private String serverName;
    private String portNumber;
    private String databaseName;
    private String user;
    private String password;

}
