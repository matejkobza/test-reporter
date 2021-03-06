package sk.trilobit.eskn.reporter.web;

import org.springframework.web.bind.annotation.*;
import sk.trilobit.eskn.reporter.Application;
import sk.trilobit.eskn.reporter.entity.DataSource;
import sk.trilobit.eskn.reporter.service.impl.DataSourceService;

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

    @RequestMapping(value = "/delete", method = RequestMethod.POST)
    public void delete(@RequestBody Long deleteId) {
        this.dataSourceService.delete(deleteId);
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public void update(@RequestBody DataSource dataSource) {this.dataSourceService.update(dataSource);}

    @RequestMapping(value = "/findOne", method = RequestMethod.GET)
    public DataSource findOne(@RequestParam(name = "setting", required = true) Long setting) {
       return (DataSource) this.dataSourceService.findOne(setting);
    }

}
