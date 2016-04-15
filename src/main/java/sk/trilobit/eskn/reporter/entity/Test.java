package sk.trilobit.eskn.reporter.entity;

import javax.persistence.*;

/**
 * Created by doloi72 on 18.12.2015.
 */
@Entity
@Table(name = "TESTY_DEF")
public class Test extends EntityWithId {

    @Column(name = "AKT")
    private int akt;

    @Column(name = "SKUPINA")
    private String group;

    @Column(name = "KOD")
    private String code;

    @Column(name = "NAZOV")
    private String name;

    @Column(name = "SRC_SQL")
    private String sourceSql;

    @Column(name = "TRG_SQL")
    private String targetSql;

    @Column(name = "COND")
    private String cond;

    @Column(name = "POPIS")
    private String description;

    @ManyToOne
    private DataSource source;

    @ManyToOne
    private DataSource target;


    public DataSource getSource() {
        return source;
    }

    public void setSource(DataSource source) {
        this.source = source;
    }

    public DataSource getTarget() {
        return target;
    }

    public void setTarget(DataSource target) {
        this.target = target;
    }

    public int getAkt() {
        return akt;
    }

    public void setAkt(int akt) {
        this.akt = akt;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSourceSql() {
        return sourceSql;
    }

    public void setSourceSql(String sourceSql) {
        this.sourceSql = sourceSql;
    }

    public String getTargetSql() {
        return targetSql;
    }

    public void setTargetSql(String targetSql) {
        this.targetSql = targetSql;
    }

    public String getCond() {
        return cond;
    }

    public void setCond(String cond) {
        this.cond = cond;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
