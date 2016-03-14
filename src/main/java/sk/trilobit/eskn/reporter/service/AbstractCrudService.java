package sk.trilobit.eskn.reporter.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import sk.trilobit.eskn.reporter.entity.EntityWithId;

import java.util.List;

public abstract class AbstractCrudService<E extends EntityWithId> {

    public abstract JpaRepository getRepository();

    public List<E> findAll() {
        return getRepository().findAll();
    }

    public Page<E> findAll(Pageable pageable) {
        return getRepository().findAll(pageable);
    }

    public Long save(E entity) {
        return ((E)getRepository().save(entity)).getId();
    }

    public E update(E entity) {
        return (E)getRepository().save(entity);
    }

    public void delete(E entity) {
        getRepository().delete(entity);
    }

    public void delete(Long id) {
        E entity = (E)getRepository().findOne(id);
        getRepository().delete(entity.getId());
    }

    public E findOne(Long id) {
        return (E)getRepository().findOne(id);
    }

}
