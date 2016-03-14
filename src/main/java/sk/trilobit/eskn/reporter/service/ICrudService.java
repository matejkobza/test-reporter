package sk.trilobit.eskn.reporter.service;

import sk.trilobit.eskn.reporter.entity.EntityWithId;

import java.util.List;

public interface ICrudService<T extends EntityWithId> {

    Long save(T entity);

    T update(T entity);

    List<T> findAll();

    T findOne(Long id);

    void delete(T entity);

    void delete(Long id);
}
