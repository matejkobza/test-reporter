package sk.trilobit.eskn.reporter.web;

import org.springframework.web.accept.MediaTypeFileExtensionResolver;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class SampleController {

	@RequestMapping(value = "/loadTests", method = RequestMethod.GET)
	public List<String> helloWorld() {
		return new ArrayList<String>();
	}

}
