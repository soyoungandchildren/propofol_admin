package kr.co.sist.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.InquiryDetail;
import kr.co.sist.domain.InquiryList;
import kr.co.sist.domain.InquiryReply;
import kr.co.sist.service.InquiryService;
import kr.co.sist.vo.InquiryPageSetVO;
import kr.co.sist.vo.InquiryReplyVO;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;


@Controller
public class InquiryController {
	
	
	
	

	@RequestMapping(value="inquiry_board.do",method=GET)
	public String inquiry_board(InquiryPageSetVO ipsvo,Model model,HttpSession session) {
		if(null==session.getAttribute("id")) {
			
			return "/login/loginform";
		}
			InquiryService is=new InquiryService();
			int totalCount=is.totalCount();//총 개시물의 수를 구해야한다
			int pageScale=is.pageScale();//한화면에 보여줄 개시물의수 10개
			int totalPage=is.totalPage();//전체 개시물을 보여주기 위한 총페이지수
			
			System.out.println(ipsvo+"///"+totalPage+"----" );
			if(ipsvo.getCurrentPage() == 0) {//web parameter에 값이 없을때 
				ipsvo.setCurrentPage(1);//1번부터 조회해야 하니까 1로 설정
			}
			/*if(ipsvo.getBigPage() == 0 || ipsvo.getBigPage() ==-1) {
				ipsvo.setBigPage(0);
			}*/
			/*if(ipsvo.getBigPage()>=10) {
				ipsvo.setCurrentPage(ipsvo.getBigPage()+1);
			}*/
			int startNum=is.startNum(ipsvo.getCurrentPage());//시작번호
			int endNum=is.endNum(startNum);//끝번호
			
			
			ipsvo.setStartNum(startNum);
			ipsvo.setEndNum(endNum);
			
			List<InquiryList> inquiryList=is.searchDiaryList(ipsvo);// 리스트 목록을 조회
			System.out.println(ipsvo+"///"+totalPage);
			
//			String indexList=is.indexList(ipsvo.getCurrentPage(),totalPage, "list.do");
			model.addAttribute("inquiryList",inquiryList);
			model.addAttribute("currentpage",ipsvo.getCurrentPage());
//			model.addAttribute("pageScale",pageScale);
			model.addAttribute("totalPage",totalPage);
			model.addAttribute("totalCount",totalCount);
			model.addAttribute("bigPage", ipsvo.getBigPage());
			model.addAttribute("admin",session.getAttribute("id"));
			model.addAttribute("auth", session.getAttribute("auth"));
			
		return "/inquiry/inquiry_board";
	}
	
	
	
	
	@RequestMapping(value="bbs_read.do",method=GET)
	public String inquiry_read(int num,Model model,HttpSession session ) {
		if(null==session.getAttribute("id")) {
			
			return "/login/loginform";
		}
		
		InquiryService is=new InquiryService();
		InquiryDetail id=is.searchSelectInquiry(num);
		InquiryReply ir=null;
		String adminid="";
		
		adminid=(String)session.getAttribute("id");
		if("Y".equals(id.getStatus())) {
				ir=is.selectReadReply(num);
				model.addAttribute("readreply", ir);
				adminid=ir.getAdmin_id();
		}
		model.addAttribute("selectinquiry", id);
		model.addAttribute("adminid",adminid );
		model.addAttribute("auth", session.getAttribute("auth"));
		
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
		
		json=is.delete(num);
		
		
		return json.toJSONString();
	}
	
	@ResponseBody
	@RequestMapping(value="deleteinquiryre.do",method=GET)
	public String updatere(int num) {
			JSONObject json=null;
		InquiryService is=new InquiryService();
		json=is.updatere(num);
		
		
		return json.toJSONString();
	}
	
	
	
	
}
