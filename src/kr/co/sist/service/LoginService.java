package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import kr.co.sist.dao.MyBatisDAO;
import kr.co.sist.domain.LoginCheckResult;
import kr.co.sist.vo.LoginCheckVO;

@Component
public class LoginService {
	
	@Autowired
	private MyBatisDAO mb_dao;

	
	public LoginCheckResult loginProcess(String id,String pass) {
		LoginCheckResult  lcr=null;
		
		lcr=mb_dao.idCheck(new LoginCheckVO(id, pass));
		System.out.println("service"+id+"/"+pass);
		
		return lcr;
	}

	
	
}
