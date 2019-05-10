package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.support.SessionStatus;

import kr.co.sist.domain.LoginCheckResult;
import kr.co.sist.service.LoginService;

@Controller
public class MainController {
	
	@Autowired
	private LoginService ls;
	
	@RequestMapping(value="/login.do",method=GET)
	public String loginForm() {
		
		return "/login/loginform";
	}
	
	
	
	
	@RequestMapping(value="loginform.do", method=RequestMethod.POST)
	public String loginprocess(HttpServletRequest request,HttpSession session, Model model) {
		LoginCheckResult lcr=null;
		String id = request.getParameter("userID");
		String pass = request.getParameter("Password");
		
		lcr=ls.loginProcess(id,pass);
		if(lcr == null) {
			
			return "/login/loginform";
		}
		if( !("".equals(id) && "".equals(pass)) ) {// 널이 아니면 들어가지
			if(!(session.getAttribute("name")==lcr.getAdmin_id())) {
				
				session.setAttribute("id", lcr.getAdmin_id());
				session.setAttribute("auth", lcr.getAuthority());
				session.setMaxInactiveInterval(60);
			}
		}
		
		
		
		return "/login/temp";
	} 
	
	// 로그아웃!
	@RequestMapping(value="logout.do",method=GET)
	public String logout(SessionStatus ss) {
		ss.isComplete();
		
		
		return "/login/loginform";
	}
	
	
	
	
	

}
