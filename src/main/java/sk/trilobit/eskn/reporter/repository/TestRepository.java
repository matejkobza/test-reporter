package sk.trilobit.eskn.reporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sk.trilobit.eskn.reporter.entity.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 21.12.15
 * Time: 9:09
 */
public interface TestRepository extends JpaRepository<Test, Long> {

    @Override
    @Query
    List<Test> findAll();
}
