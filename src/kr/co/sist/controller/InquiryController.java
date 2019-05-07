package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.domain.InquiryList;
import kr.co.sist.service.InquiryService;
import kr.co.sist.service.LoginService;
import kr.co.sist.vo.InquiryPageSetVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;


@Controller
public class InquiryController {
	
	@Autowired
	private LoginService ls;

	@RequestMapping(value="inquiry_board.do",method=GET)
	public String inquiry_board(InquiryPageSetVO ipsvo,Model model ) {
			
			InquiryService is=new InquiryService();
			int totalCount=is.totalCount();//총 개시물의 수를 구해야한다
			int pageScale=is.pageScale();//한화면에 보여줄 개시물의수 10개
			int totalPage=is.totalPage(totalCount);//전체 개시물을 보여주기 위한 총페이지수
			if(ipsvo.getCurrentPage() == 0) {//web parameter에 값이 없을때 
				ipsvo.setCurrentPage(1);//1번부터 조회해야 하니까 1로 설정
			}
			int startNum=is.startNum(ipsvo.getCurrentPage());//시작번호
			int endNum=is.endNum(startNum);//끝번호
			
			ipsvo.setStartNum(startNum);
			ipsvo.setEndNum(endNum);
			
			List<InquiryList> inquiryList=is.searchDiaryList(ipsvo);// 리스트 목록을 조회
			
//			String indexList=is.indexList(ipsvo.getCurrentPage(),totalPage, "list.do");
			model.addAttribute("inquiryList",inquiryList);
//			model.addAttribute("indexList",indexList);
//			model.addAttribute("pageScale",pageScale);
//			model.addAttribute("totalCount",totalCount);
			
		
		
		return "/inquiry/inquiry_board";
	}
	
}
