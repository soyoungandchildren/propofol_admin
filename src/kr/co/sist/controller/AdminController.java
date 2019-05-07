package kr.co.sist.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.Admin;
import kr.co.sist.service.AdminService;
import kr.co.sist.vo.AddAdminVO;
import kr.co.sist.vo.ChangeAuthorityVO;
import kr.co.sist.vo.ModifyAdminInfoVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.json.simple.JSONObject;

@Controller
public class AdminController {
	
	@Autowired(required=false)
	private AdminService as;

	@RequestMapping(value="/admin.do", method=GET)
	public String goToAdmin() {
		return "admin/admin";
	}
	
	@RequestMapping(value="/admin_list.do",method=GET)
	public String goToAdminList(Model model) {
		List<Admin> list = as.searchAdminList();
		model.addAttribute("adminList", list);
		
		return "admin/admin_list";
	}//goToAdminList
	
	@RequestMapping(value="/admin_add.do",method=GET)
	public String goToAdminAdd() {
		return "admin/admin_add";
	}
	
	@ResponseBody
	@RequestMapping(value="/modify_admin_info.do", method=POST, produces="text/plain;charset=UTF-8")
	public String modifyAdminInfo(ModifyAdminInfoVO maiVO) {
		maiVO.setAdmin_id("id1");
		JSONObject json = as.modifyAdminInfo(maiVO);
		return json.toJSONString();
	}//modifyAdminInfo
	
	@ResponseBody
	@RequestMapping(value="/add_admin_account.do", method=POST, produces="text/plain;charset=UTF-8")
	public String addAdmin(AddAdminVO aaVO){
		JSONObject json = as.addAdmin(aaVO);
		return json.toJSONString();
	}//addAdmin

	@ResponseBody
	@RequestMapping(value="/change_auth.do", method=POST)
	public String changeAuthority(ChangeAuthorityVO caVO) {
		JSONObject json = as.changeAuthority(caVO);
		return json.toJSONString();
	}//changeAuthority
	
	@ResponseBody
	@RequestMapping(value="/remove_acco.do", method=POST, produces="text/plain;charset=UTF-8")
	public String removeAccount(String admin_id) {
		JSONObject json = as.removeAccount(admin_id);
		return json.toJSONString();
	}
	
}//Class
