package kr.co.sist.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.sist.dao.AdminDAO;
import kr.co.sist.domain.Admin;
import kr.co.sist.vo.AddAdminVO;
import kr.co.sist.vo.ModifyAdminInfoVO;

@Component
public class AdminService {
	
	@Autowired(required=false)
	private AdminDAO aDAO;
	
	public JSONObject modifyAdminInfo(ModifyAdminInfoVO maiVO) {
		Map<Object, Object> map = new HashMap<>();
		
		if(aDAO.updateAdminInfo(maiVO)==1) {
			map.put("resultMsg", "계정의 정보를 성공적으로 변경하였습니다.");
		}else {
			map.put("resultMsg", "변경 중 오류가 발생하였습니다. 기술 지원에 문의 부탁드립니다.");
		}//end else
		
		JSONObject json = new JSONObject(map);
		return json;
	}//modifyAdminInfo
	
	public List<Admin> searchAdminList(){
		List<Admin> list = aDAO.selectAdminList();
		return list;
	}//searchAdminList
	
	
	public JSONObject addAdmin(AddAdminVO aaVO) {
		Map<Object, Object> map = new HashMap<>();
		boolean resultFlag = false;
		String resultMsg = "추가 중 오류가 발생하였습니다. 기술 지원에 문의 부탁드립니다.";
		
		if(aDAO.insertAdmin(aaVO)==1) {
			resultMsg = "관리자를 추가하였습니다.";
			resultFlag = true;
		}//end if
		map.put("resultMsg", resultMsg);
		map.put("resultFlag", resultFlag);
		
		JSONObject json = new JSONObject(map);
		return json;
	}//addAdmin
	
	
	public JSONObject changeAuthority(String admin_id) {
		Map<Object, Object> map = new HashMap<>();
		if(aDAO.updateAuthority(admin_id)==1) {
			map.put("resultFlag", true);
		}else {
			map.put("resultFlag", false);
		}//end else
		
		JSONObject json = new JSONObject(map);
		return json;
	}//changeAuthority
	

}//Class
