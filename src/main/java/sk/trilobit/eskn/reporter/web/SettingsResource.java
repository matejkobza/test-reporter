package sk.trilobit.eskn.reporter.web;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sk.trilobit.eskn.reporter.Application;
import sk.trilobit.eskn.reporter.entity.DataSource;
import sk.trilobit.eskn.reporter.service.DataSourceService;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 02.01.16
 * Time: 12:42
 */
@RestController
@RequestMapping(Application.ROOT_API + "/settings")
public class SettingsResource {

    @Inject
    private DataSourceService dataSourceService;

    @RequestMapping("/get")
    public List<DataSource> get() {
        return dataSourceService.findAll();
    }

    @RequestMapping("/save")
    public void save(@RequestBody DataSource dataSource) {
        this.dataSourceService.save(dataSource);
    }

}
