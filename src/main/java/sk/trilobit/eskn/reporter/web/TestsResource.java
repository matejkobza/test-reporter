package sk.trilobit.eskn.reporter.web;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import sk.trilobit.eskn.reporter.Application;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.TestRepository;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(Application.ROOT_API)
public class TestsResource {

	@Inject
	private TestRepository testRepository;

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public @ResponseBody List<Test> findTest() {
		return testRepository.findAll();
	}

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public @ResponseBody List<Test> saveTest(@RequestBody Test test) {
		testRepository.save(test);
		return testRepository.findAll();
	}

}
