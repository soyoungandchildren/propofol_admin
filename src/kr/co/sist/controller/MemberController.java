package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class MemberController {

	@RequestMapping(value="/member_list.do", method=GET)
	public String goToMemberList() {
		return "member/member_list";
	}//
	
	
	@RequestMapping(value="/member_info.do", method=GET)
	public String goToMemberInfo() {
		return "member/member_info";
	}//
	
	
	
}//Class
