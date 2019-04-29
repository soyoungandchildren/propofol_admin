package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.service.LoginService;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class InquiryController {
	
	@Autowired
	private LoginService ls;

	@RequestMapping(value="inquiry_board.do",method=GET)
	public String inquiry_board() {
		
		
		return "/inquiry/inquiry_board";
	}
	
}
