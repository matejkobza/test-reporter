package sk.trilobit.eskn.reporter.service;

/**
 * Created with IntelliJ IDEA.
 * User: matejkobza
 * Date: 02.01.16
 * Time: 13:02
 */
public interface ITestService {

    /**
     * runs test and records its result.
     * @param testId
     * @return
     */
    boolean runTest(Long testId);

}
