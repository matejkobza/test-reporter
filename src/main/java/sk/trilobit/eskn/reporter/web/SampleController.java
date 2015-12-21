package sk.trilobit.eskn.reporter.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.TestRepository;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {

	@Inject
	private TestRepository testRepository;

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public @ResponseBody List<Test> findTest() {
		return testRepository.findAll();
	}

	@RequestMapping(value = "/load", method = RequestMethod.POST)
	public @ResponseBody List<Test> saveTest() {
		return testRepository.findAll();
	}

}
