package sk.trilobit.eskn.reporter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table
public class DataSource extends EntityWithId {

    @Column
    private String driverClassName;

    @Column
    private String serverName;

    @Column
    private String portNumber;

    @Column
    private String databaseName;

    @Column
    private String user;

    @Column
    private String password;



}
