package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.LoginCheckResult;
import kr.co.sist.service.LoginService;
import kr.co.sist.vo.LoginCheckVO;

@Controller
public class MainController {
	
	@Autowired
	private LoginService ls;
	
	@RequestMapping(value="/login.do",method=GET)
	public String loginForm() {
		
		return "/login/loginform";
	}
	
	
	
	
	@RequestMapping(value="/loginform.do", method=GET)
	public String loginprocess(HttpServletRequest request,HttpSession session, Model model) {
		LoginCheckResult lcr=null;
		String id = request.getParameter("userID");
		String pass = request.getParameter("Password");
		
//		LoginCheckVO lcvo=new LoginCheckVO("sso", "1234");
		lcr=ls.loginProcess(id,pass);
		
		if(!("".equals(id) && "".equals(pass)) ) {
			if(session==null) {
				session.setAttribute("name", lcr.getName());
				session.setAttribute("auth", lcr.getAuthority());
				session.setMaxInactiveInterval(60);
			}
		}
		
		
		model.addAttribute("userinfo",lcr);
		
		return "login/temp";
	} 
	
	
	
	
	
	
	

}
