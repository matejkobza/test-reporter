package sk.trilobit.eskn.reporter.web;

import ma.glasnost.orika.MapperFacade;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sk.trilobit.eskn.reporter.Application;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.DataSourceRepository;
import sk.trilobit.eskn.reporter.repository.TestRepository;
import sk.trilobit.eskn.reporter.service.ITestService;
import sk.trilobit.eskn.reporter.web.dto.TestDTO;

import javax.inject.Inject;
import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping(Application.ROOT_API + "/test")
public class TestResource {

	@Inject
	private TestRepository testRepository;

    @Inject
    private DataSourceRepository dataSourceRepository;

    @Inject
    private ITestService testService;

    @Inject
    private MapperFacade mapperFacade;

	@RequestMapping(value = "/load", method = RequestMethod.GET)
    @ResponseBody
    public List<TestDTO> findTest() {
        List<Test> tests = testRepository.findAll();

        tests.stream().map(e -> sortRuns(e));

        List<TestDTO> testDTOs = mapperFacade.mapAsList(tests, TestDTO.class);
        return testDTOs;
    }

    private Test sortRuns(Test e) {
        Collections.sort(e.getRuns(), (o1, o2) -> o1.getEnd().after(o2.getEnd())?1:-1);
        return e;
    }

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
    @ResponseBody
    public List<TestDTO> saveTest(@RequestBody TestDTO testDTO) {
        Test test = mapperFacade.map(testDTO, Test.class);

        test.setSource(dataSourceRepository.findOne(testDTO.getSourceDataSourceId()));
        test.setTarget(dataSourceRepository.findOne(testDTO.getTargetDataSourceId()));

        testRepository.save(test);
        return findTest();
    }

    @RequestMapping(value = "/run", method = RequestMethod.POST)
    @ResponseBody
    public Boolean runTest(@RequestBody Long testId) {
        return testService.runTest(testId);
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Boolean deleteTest(@PathVariable("id") Long testId) {
        testRepository.delete(testId);
        return true;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Test findTest(@PathVariable("id") Long testId) {
        return testRepository.findOne(testId);
    }

}
