package sk.trilobit.eskn.reporter.entity;

import javax.persistence.Table;
import javax.persistence.Column;
import javax.persistence.Entity;
import java.sql.Time;

/**
 * Created by doloi72 on 18.12.2015.
 */
@Entity
@Table(name = "TESTY_RUNS")

public class Runs {

    @JoinColumn(name = "RUN_ID")
    private long run_id;

    @JoinColumn(name = "TEST_ID")
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


    public long getRun_id() {
        return run_id;
    }

    public void setRun_id(long run_id) {
        this.run_id = run_id;
    }

    public int getTest_id() {
        return test_id;
    }

    public void setTest_id(int test_id) {
        this.test_id = test_id;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getSrc_result() {
        return src_result;
    }

    public void setSrc_result(String src_result) {
        this.src_result = src_result;
    }

    public String getTrg_result() {
        return trg_result;
    }

    public void setTrg_result(String trg_result) {
        this.trg_result = trg_result;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Time getCas() {
        return cas;
    }

    public void setCas(Time cas) {
        this.cas = cas;
    }
}
