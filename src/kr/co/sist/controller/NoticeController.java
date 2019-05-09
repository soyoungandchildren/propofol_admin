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
import kr.co.sist.domain.NoticeList;
import kr.co.sist.service.NoticeService;
import kr.co.sist.vo.ModifyNoticeVO;
import kr.co.sist.vo.SearchNoticeVO;
import kr.co.sist.vo.WriteNoticeVO;

@Controller
public class NoticeController {

	@Autowired(required=false)
	private NoticeService ns;
	
	
	@RequestMapping(value="/notice.do", method= {GET,POST})
	public String searchNoticeList(SearchNoticeVO snVO, Model model) {
		if(snVO.getSelectedPageIndex() == 0) {
			snVO.setSelectedPageIndex(1);
		}//end if
		
		List<NoticeList> list = ns.searchNoticeList(snVO);
		int totalPageIdx = ns.totalPageIndexList(snVO);
		
		model.addAttribute("selectedPageIndex", snVO.getSelectedPageIndex());
		model.addAttribute("noticeList", list);
		model.addAttribute("totalPageIdx", totalPageIdx);
		model.addAttribute("pageScale", ns.singlePageScale());
		model.addAttribute("bigPage", snVO.getBigPage());
		model.addAttribute("maxBigPage", totalPageIdx/ns.singlePageScale());
		return "notice/notice_board";
	}//searchNoticeList
	
	
	@RequestMapping(value="/notice_write.do", method=GET)
	public String moveToNoticeWrite() {
		return "notice/notice_write";
	}//moveToNoticeWrite

	@ResponseBody
	@RequestMapping(value="/confirm_write.do", method=POST, produces="text/plain;charset=UTF-8")
	public String writeNotice(WriteNoticeVO wnVO) {
		///////////////////////////////////
		wnVO.setAdmin_id("id1");
		///////////////////////////////////
		
		JSONObject js = ns.writeNotice(wnVO);
		return js.toJSONString();
	}//writeNotice
	
	
	@RequestMapping(value="/notice_read.do", method=POST)
	public String moveToNoticeRead(int notice_no, Model model) {
		
		NoticeDetail nd = ns.searchNoticeDetail(notice_no);
		model.addAttribute("noticeDetail", nd);
		
		return "notice/notice_read";
	}//goNoticeUpdate
	
	
	@ResponseBody
	@RequestMapping(value="/modify_notice.do", method=POST, produces="text/plain;charset=UTF-8")
	public String modifyNotice(ModifyNoticeVO mnVO, Model model) {
		JSONObject json = ns.modifyNoticeDetail(mnVO);
		
		return json.toJSONString();
	}//goNoticeUpdate
	
	@ResponseBody
	@RequestMapping(value="/remove_notice.do", method=POST, produces="text/plain;charset=UTF-8")
	public String removeNotice(int num) {
		JSONObject json = ns.removeNotice(num);
		return json.toJSONString();
	}//removeNotice
	
}//Class
