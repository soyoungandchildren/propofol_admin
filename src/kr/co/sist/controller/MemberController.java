package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.domain.MemberList;
import kr.co.sist.service.MemberService;
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
		int pageIdx = ms.totalPageIndexList();
		 
		model.addAttribute("memberList", list);
		model.addAttribute("pageIdx", pageIdx);
		model.addAttribute("pageScale", ms.singlePageScale());
		model.addAttribute("bigPage", smVO.getBigPage());
		model.addAttribute("maxBigPage", pageIdx/ms.singlePageScale());
		
		
		return "member/member_list";
	}//
	
	
	@RequestMapping(value="/member_info.do", method=GET)
	public String goToMemberInfo() {
		return "member/member_info";
	}//

	
	
}//Class
