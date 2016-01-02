package sk.trilobit.eskn.reporter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import sk.trilobit.eskn.reporter.entity.Run;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 02.01.16
 * Time: 13:16
 */
public interface RunRepository extends JpaRepository<Run, Long> {
}
