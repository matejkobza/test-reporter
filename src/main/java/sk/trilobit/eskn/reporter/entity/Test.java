package sk.trilobit.eskn.reporter.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by doloi72 on 18.12.2015.
 */
@Entity
@Table(name = "TESTY_DEF")
public class Test {

    public long getId() {
        return id;
    }

    public void setId(final long id) {
        this.id = id;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name = "AKT")
    private int akt;

    @Column(name = "SKUPINA")
    private String skupina;

    @Column(name = "KOD")
    private String kod;

    @Column(name = "NAZOV")
    private String nazov;

    @Column(name = "SRC_SQL")
    private String src_sql;

    @Column(name = "TRG_SQL")
    private String trg_sql;

    @Column(name = "COND")
    private String cond;

    @Column(name = "POPIS")
    private String popis;

    @ManyToOne
    private DataSource source;

    @ManyToOne
    private DataSource target;


    public int getAkt() {
        return akt;
    }

    public void setAkt(int akt) {
        this.akt = akt;
    }

    public String getSkupina() {
        return skupina;
    }

    public void setSkupina(String skupina) {
        this.skupina = skupina;
    }

    public String getKod() {
        return kod;
    }

    public void setKod(String kod) {
        this.kod = kod;
    }

    public String getNazov() {
        return nazov;
    }

    public void setNazov(String nazov) {
        this.nazov = nazov;
    }

    public String getSrc_sql() {
        return src_sql;
    }

    public void setSrc_sql(String src_sql) {
        this.src_sql = src_sql;
    }

    public String getTrg_sql() {
        return trg_sql;
    }

    public void setTrg_sql(String trg_sql) {
        this.trg_sql = trg_sql;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }
}
