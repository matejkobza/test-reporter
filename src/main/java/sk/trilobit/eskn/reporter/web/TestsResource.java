package sk.trilobit.eskn.reporter.web;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sk.trilobit.eskn.reporter.Application;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.TestRepository;
import sk.trilobit.eskn.reporter.service.ITestService;
import sk.trilobit.eskn.reporter.web.dto.TestDTO;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(Application.ROOT_API + "/test")
public class TestsResource {

	@Inject
	private TestRepository testRepository;

	@Inject
	private ITestService testService;

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public @ResponseBody List<Test> findTest() {
		return testRepository.findAll();
	}

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public
	@ResponseBody
	List<Test> saveTest(@RequestBody TestDTO test) {
		this.testService.save(test);
		return testRepository.findAll();
	}

}
