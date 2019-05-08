package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.MemberInfo;
import kr.co.sist.domain.MemberList;
import kr.co.sist.service.MemberService;
import kr.co.sist.vo.ChangeBanStatusVO;
import kr.co.sist.vo.ModifyMemberInfoVO;
import kr.co.sist.vo.SearchMemberVO;

@Controller
public class MemberController {

	@Autowired(required=false)
	private MemberService ms;
	
	@RequestMapping(value="/member_list.do", method= {GET,POST})
	public String goToMemberList(SearchMemberVO smVO, Model model) {
		if(smVO.getSelectedPageIndex() == 0) {
			smVO.setSelectedPageIndex(1);
		}//end if
		
		List<MemberList> list = ms.searchMemberList(smVO);
		int totalPageIdx = ms.totalPageIndexList(smVO);
		
		model.addAttribute("memberList", list);
		model.addAttribute("totalPageIdx", totalPageIdx);
		model.addAttribute("pageScale", ms.singlePageScale());
		model.addAttribute("bigPage", smVO.getBigPage());
		//totalPageIdx -> 20 -> 2로나눠 2가 가면안됨.
		
		model.addAttribute("maxBigPage", totalPageIdx/ms.singlePageScale());
//		System.out.println(totalPageIdx/ms.singlePageScale());
//		System.out.println("컨트롤러에서의 토탈 페이지 인덱스 : "+totalPageIdx);
//		System.out.println("컨트롤러에서의 VO의 겟빅페이지 : "+smVO.getBigPage());
		return "member/member_list";
	}//goToMemberList
	
	
	@RequestMapping(value="/member_info.do", method=GET)
	public String goToMemberInfo(Model model, String user_id) {
		MemberInfo mi = ms.searchMemberInfo(user_id);
		model.addAttribute("memberInfo", mi);
		return "member/member_info";
	}//goToMemberInfo
	
	
	@ResponseBody
	@RequestMapping(value="/change_isbanned.do", method=POST, produces="text/plain;charset=UTF-8")
	public String changeBanStatus(ChangeBanStatusVO cbsVO) {
		JSONObject json = ms.changeBanStatus(cbsVO);
		return json.toJSONString();
	}//changeBanStatus
	
	@ResponseBody
	@RequestMapping(value="/modify_member_info.do", method=POST, produces="text/plain;charset=UTF-8")
	public String modifyMemberInfo(ModifyMemberInfoVO mmiVO) {
		JSONObject json = ms.modifyMemberInfo(mmiVO);
		return json.toJSONString();
	}//modifyMemberInfo
	
}//Class
 