package sk.trilobit.eskn.reporter.web.config;

import ma.glasnost.orika.MapperFacade;
import ma.glasnost.orika.MapperFactory;
import ma.glasnost.orika.impl.DefaultMapperFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.web.dto.TestDTO;

@Configuration
public class MappingConfig {

    MapperFactory mapperFactory = new DefaultMapperFactory.Builder().build();

    @Bean
    public MapperFactory getMapperFactory() {
        mapperFactory.classMap(Test.class, TestDTO.class)
                .byDefault()
                .register();

        mapperFactory.classMap(TestDTO.class, Test.class)
                .byDefault()
                .register();

        return mapperFactory;
    }

    @Bean
    public MapperFacade getMapperFacade() {
        return mapperFactory.getMapperFacade();
    }

}
