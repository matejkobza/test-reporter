package sk.trilobit.eskn.reporter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by doloi72 on 18.12.2015.
 */
@Getter
@Setter
@Entity
@Table(name = "TESTY_RUNS")
public class Run extends EntityWithId {

    @ManyToOne
    @JoinColumn(name = "TEST_ID")
    private Test test;

    @Column(name = "STATUS")
    private int status;

    @Column(name = "SRC_RESULT")
    private String src_result;

    @Column(name = "TRG_RESULT")
    private String trg_result;

    @Column(name = "ERROR")
    private String error;

    @Column(name = "CAS")
    private Timestamp cas;

    @Column(name = "START")
    private Timestamp start;

    @Column(name = "END")
    private Timestamp end;

}
