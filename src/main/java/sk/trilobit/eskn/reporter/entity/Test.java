package sk.trilobit.eskn.reporter.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.List;

/**
 * Created by doloi72 on 18.12.2015.
 */
@Getter
@Setter
@Entity
@Table(name = "TESTY_DEF")
@NamedQuery(name = "Test.findAll", query = "SELECT DISTINCT(t) FROM Test t LEFT JOIN FETCH t.runs")
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

    @OneToMany(mappedBy = "test")
    private List<Run> runs;

}
