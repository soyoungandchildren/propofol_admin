package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

	
	//��û�� Ư���̸����� ��� ó���ҷ��� value="/�����̸�/��û.do�� �ϸ� �ȴ�.
	@RequestMapping(value="notice_board.do", method=GET)
	public String sessionForm() {
		return "notice_board";
	}//sessionForm
}
