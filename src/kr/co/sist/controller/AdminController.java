package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class AdminController {

	@RequestMapping(value="/admin.do", method=GET)
	public String goToAdmin() {
		return "admin/admin";
	}
	
	@RequestMapping(value="/admin_list.do",method=GET)
	public String goToAdminList() {
		return "admin/admin_list";
	}
	
	
}
