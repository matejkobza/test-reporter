package sk.trilobit.eskn.reporter.web.dto;

import lombok.Getter;
import lombok.Setter;
import sk.trilobit.eskn.reporter.entity.Run;

import java.util.List;

@Getter
@Setter
public class TestDTO {
    private Long id;
    private Long akt;
    private String group;
    private String code;
    private String name;
    private String sourceSql;
    private String targetSql;
    private String cond;
    private String description;
    private Long sourceDataSourceId;
    private Long targetDataSourceId;
    private List<Run> runs;
}
