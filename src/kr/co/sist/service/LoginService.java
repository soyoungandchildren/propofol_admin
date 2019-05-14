package kr.co.sist.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.MyBatisDao;
import kr.co.sist.domain.LoginCheckResult;
import kr.co.sist.vo.LoginCheckVO;

@Component
public class LoginService {
	
	@Autowired
	private MyBatisDao mb_dao;

	
	public LoginCheckResult loginProcess(String id,String pass) {
		LoginCheckResult  lcr=null;
		
		lcr=mb_dao.idCheck(new LoginCheckVO(id, pass));
		
		return lcr;
	}

	
	
}
