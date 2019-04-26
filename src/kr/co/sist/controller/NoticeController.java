package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.domain.SearchNotice;
import kr.co.sist.service.NoticeService;
import kr.co.sist.vo.SearchNoticeVO;

@Controller
public class NoticeController {

	@Autowired(required=false)
	NoticeService ns;
	
	
	@RequestMapping(value="/notice.do", method= {GET,POST})
	public String selectNotice(SearchNoticeVO snVO, Model m) {
		
		
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
	public String goNoticeWrite() {
		return "notice/notice_write";
	}
	
	@RequestMapping(value="/notice_read.do", method=GET)
	public String goNoticeUpdate() {
		return "notice/notice_read";
	}
	
}//Class
