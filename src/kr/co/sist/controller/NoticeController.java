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

import kr.co.sist.domain.NoticeDetail;
import kr.co.sist.domain.SearchNotice;
import kr.co.sist.service.NoticeService;
import kr.co.sist.vo.ModifyNoticeVO;
import kr.co.sist.vo.SearchNoticeVO;

@Controller
public class NoticeController {

	@Autowired(required=false)
	NoticeService ns;
	
	
	@RequestMapping(value="/notice.do", method= {GET,POST})
	public String searchNoticeList(SearchNoticeVO snVO, Model m) {
		
		if(snVO.getSelectedPageIndex() == 0) {
			snVO.setSelectedPageIndex(1);
		}
		
		
		List<SearchNotice> list = ns.searchNoticeList(snVO);
		String pageIdx = ns.totalPageIndexList();
		
		m.addAttribute("noticeList", list);
		m.addAttribute("pageIdx", pageIdx);
		
		return "notice/notice_board";
	}
	
	@RequestMapping(value="/notice_write.do", method=GET)
	public String moveToNoticeWrite() {
		return "notice/notice_write";
	}
	
	@RequestMapping(value="/notice_read.do", method=GET)
	public String moveToNoticeRead(int num, Model model) {
		
		NoticeDetail nd = ns.searchNoticeDetail(num);
		model.addAttribute("noticeDetail", nd);
		
		return "notice/notice_read";
	}//goNoticeUpdate
	
	
	@ResponseBody
	@RequestMapping(value="/modify_notice.do", method=POST)
	public String modifyNotice(ModifyNoticeVO mnVO, Model model) {
		System.out.println(mnVO.getTitle());
		System.out.println(mnVO.getBody());
		System.out.println(mnVO.getNum());
		
		JSONObject json = ns.modifyNoticeDetail(mnVO);
		
		return json.toJSONString();
	}//goNoticeUpdate
	
	
	
}//Class
