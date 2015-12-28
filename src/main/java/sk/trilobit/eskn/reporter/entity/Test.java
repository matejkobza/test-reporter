package sk.trilobit.eskn.reporter.entity;

import javax.persistence.*;

/**
 * Created by doloi72 on 18.12.2015.
 */
@Entity
@Table(name = "TESTY_DEF")

public class Test {

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

    @Column(name = "OOND")
    private String oond;

    @Column(name = "POPIS")
    private String popis;

    @Column(name = "SRC_PAR")
    private String src_par;

    @Column(name = "TRG_PAR")
    private String trg_par;


    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

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

    public String getOond() {
        return oond;
    }

    public void setOond(String oond) {
        this.oond = oond;
    }

    public String getPopis() {
        return popis;
    }

    public void setPopis(String popis) {
        this.popis = popis;
    }

    public String getSrc_par() {
        return src_par;
    }

    public void setSrc_par(String src_par) {
        this.src_par = src_par;
    }

    public String getTrg_par() {
        return trg_par;
    }

    public void setTrg_par(String trg_par) {
        this.trg_par = trg_par;
    }

}
