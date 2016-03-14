package sk.trilobit.eskn.reporter.service;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import sk.trilobit.eskn.reporter.entity.DataSource;
import sk.trilobit.eskn.reporter.repository.DataSourceRepository;

import javax.inject.Inject;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 02.01.16
 * Time: 12:48
 */
@Service
public class DataSourceService extends AbstractCrudService implements IDataSourceService {

    @Inject
    private DataSourceRepository dataSourceRepository;

    @Override
    public JpaRepository getRepository() {
        return dataSourceRepository;
    }
}
