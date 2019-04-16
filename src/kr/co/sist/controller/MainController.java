package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	//요청을 특정이름으로 묶어서 처리할려면 value="/묶을이름/요청.do로 하면 된다.
	@RequestMapping(value="notice_board.do", method=GET)
	public String sessionForm() {
		return "notice_board";
	}//sessionForm
}
