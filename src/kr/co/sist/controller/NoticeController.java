package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;
import static org.springframework.web.bind.annotation.RequestMethod.POST;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.domain.SearchNotice;
import kr.co.sist.service.NoticeService;
import kr.co.sist.vo.SearchNoticeVO;

@Controller
public class NoticeController {

	
	@RequestMapping(value="/notice.do", method= {GET,POST})
	public String selectNotice(SearchNoticeVO snVO, Model m) {
		
		NoticeService ns = new NoticeService();
		
		if(snVO == null) {
			snVO = new SearchNoticeVO();
			snVO.setSelectedPageIndex(1);
		}
		
		
		List<SearchNotice> list = ns.searchNoticeList(snVO);
		m.addAttribute("noticeList", list);
		
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
	
//	public static void main(String[] args) {
//		ApplicationContext ac = new ClassPathXmlApplicationContext("kr/co/sist/di/applicationContext.xml");
//
//		NoticeService ns = ac.getBean("notice_service", NoticeService.class);
//		System.out.println(ns);
//	}
	
}//Class
