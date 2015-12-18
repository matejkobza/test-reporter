package sk.trilobit.eskn.reporter.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class SampleController {

	@RequestMapping(value = "/load", method = RequestMethod.GET)
	public @ResponseBody List<String> helloWorld() {
		return new ArrayList<String>();
	}

}
