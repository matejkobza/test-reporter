package sk.trilobit.eskn.reporter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "DataSource_DEF")
public class DataSource {

    @Column(name = "type")
    private String jdbcUrl;
    
    @Column(name = "driverType")
    private String driverClassName;

    @Column(name = "serverName")
    private String serverName;

    @Column(name = "portNumber")
    private String portNumber;

    @Column(name = "databaseName")
    private String databaseName;

    @Column(name = "user")
    private String user;

    @Column(name = "password")
    private String password;

}
