package sk.trilobit.eskn.reporter.web;

import ma.glasnost.orika.MapperFacade;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import sk.trilobit.eskn.reporter.Application;
import sk.trilobit.eskn.reporter.entity.Test;
import sk.trilobit.eskn.reporter.repository.TestRepository;
import sk.trilobit.eskn.reporter.web.dto.TestDTO;

import javax.inject.Inject;
import java.util.List;

@RestController
@RequestMapping(Application.ROOT_API + "/test")
public class TestsResource {

	@Inject
	private TestRepository testRepository;

    @Inject
    private MapperFacade mapperFacade;

	@RequestMapping(value = "/load", method = RequestMethod.GET)
    public
    @ResponseBody
    List<TestDTO> findTest() {
        List<TestDTO> testDTOs = mapperFacade.mapAsList(testRepository.findAll(), TestDTO.class);
        return testDTOs;
    }

	@Transactional
	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public
	@ResponseBody
    List<TestDTO> saveTest(@RequestBody TestDTO testDTO) {
        Test t = mapperFacade.map(testDTO, Test.class);
        this.testRepository.save(t);
        return findTest();
    }

}
