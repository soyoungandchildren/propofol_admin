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
	public String inquiry_board(InquiryPageSetVO ipsvo,Model model ) {
			InquiryService is=new InquiryService();
			int totalCount=is.totalCount();//�� ���ù��� ���� ���ؾ��Ѵ�
			int pageScale=is.pageScale();//��ȭ�鿡 ������ ���ù��Ǽ� 10��
			int totalPage=is.totalPage();//��ü ���ù��� �����ֱ� ���� ����������
			if(ipsvo.getCurrentPage() == 0) {//web parameter�� ���� ������ 
				ipsvo.setCurrentPage(1);//1������ ��ȸ�ؾ� �ϴϱ� 1�� ����
			}
			if(ipsvo.getBigPage() == 0 || ipsvo.getBigPage() ==-1) {
				ipsvo.setBigPage(0);
			}
			int startNum=is.startNum(ipsvo.getCurrentPage());//���۹�ȣ
			int endNum=is.endNum(startNum);//����ȣ
			
			System.out.println(startNum+"controller--startnum");
			System.out.println(ipsvo.getBigPage());
			
			
			ipsvo.setStartNum(startNum);
			ipsvo.setEndNum(endNum);
			
			List<InquiryList> inquiryList=is.searchDiaryList(ipsvo);// ����Ʈ ����� ��ȸ
			
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
