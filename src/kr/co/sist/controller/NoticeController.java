package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import static org.springframework.web.bind.annotation.RequestMethod.GET;

@Controller
public class NoticeController {

	@RequestMapping(value="/notice.do", method=GET)
	public String goNotice() {
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
