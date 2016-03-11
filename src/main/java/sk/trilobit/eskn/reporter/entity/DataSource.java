package sk.trilobit.eskn.reporter.entity;
import lombok.Data;

import javax.persistence.*;
/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 02.01.16
 * Time: 12:47
 */

//@Entity
public @Data
class DataSource {
    


    private String driverClassName;
    private String jdbcUrl;
    private String serverName;
    private String portNumber;
    private String databaseName;
    private String user;
    private String password;





}
