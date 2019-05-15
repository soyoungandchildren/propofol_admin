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
			int totalCount=is.totalCount();//�� ���ù��� ���� ���ؾ��Ѵ�
			int pageScale=is.pageScale();//��ȭ�鿡 ������ ���ù��Ǽ� 10��
			int totalPage=is.totalPage();//��ü ���ù��� �����ֱ� ���� ����������
			
			System.out.println(ipsvo+"///"+totalPage+"----" );
			if(ipsvo.getCurrentPage() == 0) {//web parameter�� ���� ������ 
				ipsvo.setCurrentPage(1);//1������ ��ȸ�ؾ� �ϴϱ� 1�� ����
			}
			/*if(ipsvo.getBigPage() == 0 || ipsvo.getBigPage() ==-1) {
				ipsvo.setBigPage(0);
			}*/
			/*if(ipsvo.getBigPage()>=10) {
				ipsvo.setCurrentPage(ipsvo.getBigPage()+1);
			}*/
			int startNum=is.startNum(ipsvo.getCurrentPage());//���۹�ȣ
			int endNum=is.endNum(startNum);//����ȣ
			
			
			ipsvo.setStartNum(startNum);
			ipsvo.setEndNum(endNum);
			
			List<InquiryList> inquiryList=is.searchDiaryList(ipsvo);// ����Ʈ ����� ��ȸ
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
