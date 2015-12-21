package sk.trilobit.eskn.reporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.trilobit.eskn.reporter.entity.Test;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 21.12.15
 * Time: 9:09
 */
public interface TestRepository extends JpaRepository<Test, Long> {

}
