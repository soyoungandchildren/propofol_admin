package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class TestController {
	
	@RequestMapping(value="inquiry.do", method=GET)
	public String test() {
		return "inquiry";
	}

}
