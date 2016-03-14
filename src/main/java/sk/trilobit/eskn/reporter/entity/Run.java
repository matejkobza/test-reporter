package sk.trilobit.eskn.reporter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Time;

/**
 * Created by doloi72 on 18.12.2015.
 */
@Entity
@Table(name = "TESTY_RUNS")
public class Run extends EntityWithId {

    @Column(name = "TEST_ID")
    private int test_id;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "SRC_RESULT")
    private String src_result;

    @Column(name = "TRG_RESULT")
    private String trg_result;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "CAS")
    private Time cas;

}
