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
	
	
	
	
	@RequestMapping(value="/loginform.do", method=RequestMethod.POST)
	public String loginprocess(HttpServletRequest request,HttpSession session, Model model) {
		LoginCheckResult lcr=null;
		String id = request.getParameter("userID");
		String pass = request.getParameter("Password");
		
//		LoginCheckVO lcvo=new LoginCheckVO("sso", "1234");
		lcr=ls.loginProcess(id,pass);
		
		if( !("".equals(id) && "".equals(pass)) ) {
			System.out.println(lcr.getName()+"///////////");
			if(!(session.getAttribute("name")==lcr.getName())) {
				session.setAttribute("name", lcr.getName());
				session.setAttribute("auth", lcr.getAuthority());
				session.setMaxInactiveInterval(60);
			}
		}
		
		System.out.println(lcr.getName()+"///"+lcr.getAuthority());
		model.addAttribute("userinfo",lcr);
		
		return "login/temp";
	} 
	
	// ·Î±×¾Æ¿ô!
	@RequestMapping(value="logout.do",method=GET)
	public String logout(SessionStatus ss) {
		ss.isComplete();
		
		
		return "/login/loginform";
	}
	
	
	
	
	

}
