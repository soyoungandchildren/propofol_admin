package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.InquiryDetail;
import kr.co.sist.domain.InquiryList;
import kr.co.sist.domain.InquiryReply;
import kr.co.sist.service.InquiryService;
import kr.co.sist.service.LoginService;
import kr.co.sist.vo.InquiryPageSetVO;
import kr.co.sist.vo.InquiryReplyVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
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
			int totalPage=is.totalPage();//전체 개시물을 보여주기 위한 총페이지수
			if(ipsvo.getCurrentPage() == 0) {//web parameter에 값이 없을때 
				ipsvo.setCurrentPage(1);//1번부터 조회해야 하니까 1로 설정
			}
			if(ipsvo.getBigPage() == 0 || ipsvo.getBigPage() ==-1) {
				ipsvo.setBigPage(0);
			}
			int startNum=is.startNum(ipsvo.getCurrentPage());//시작번호
			int endNum=is.endNum(startNum);//끝번호
			
			System.out.println(startNum+"controller--startnum");
			System.out.println(ipsvo.getBigPage());
			
			
			ipsvo.setStartNum(startNum);
			ipsvo.setEndNum(endNum);
			
			List<InquiryList> inquiryList=is.searchDiaryList(ipsvo);// 리스트 목록을 조회
			
//			String indexList=is.indexList(ipsvo.getCurrentPage(),totalPage, "list.do");
			model.addAttribute("inquiryList",inquiryList);
//			model.addAttribute("indexList",indexList);
//			model.addAttribute("pageScale",pageScale);
			model.addAttribute("totalPage",totalPage);
			model.addAttribute("totalCount",totalCount);
			model.addAttribute("bigpage", ipsvo.getBigPage());
			
			System.out.println(endNum+"controller-endnum");
			System.out.println(pageScale+"controller-pageScale");
			System.out.println(totalPage+"controller-totalPage");
		return "/inquiry/inquiry_board";
	}
	
	
	
	
	@RequestMapping(value="bbs_read.do",method=GET)
	public String inquiry_read(int num,Model model,HttpServletRequest request,HttpSession session ) {
		
		InquiryService is=new InquiryService();
		InquiryDetail id=is.searchSelectInquiry(num);
		InquiryReply ir=null;
		String name="";
		name=(String)session.getAttribute("name");
		System.out.println(id.getStatus());
		if("Y".equals(id.getStatus())) {
			System.out.println("YYYYYYYYYYYYYYYYYY");
				ir=is.selectReadReply(num);
				model.addAttribute("readreply", ir);
				name=ir.getAdmin_id();
		}
		model.addAttribute("selectinquiry", id);
		model.addAttribute("adminName",name );
		
		return "/inquiry/inquiry_read";
	}
	
	@ResponseBody
	@RequestMapping(value="add_reply.do",method=GET)
	public String writeReply(InquiryReplyVO irvo) {
		JSONObject json=null;
		InquiryService is=new InquiryService();
		
		json=is.writeReply(irvo);
		
		
		return json.toJSONString();
	}
	@ResponseBody
	@RequestMapping(value="deleteuserinquiry.do",method=GET)
	public String deleteInquiry(int num) {
		JSONObject json=null;
		InquiryService is=new InquiryService();
		System.out.println(num);
		
		json=is.delete(num);
		
		
		return json.toJSONString();
	}
	
	
	
	
}
