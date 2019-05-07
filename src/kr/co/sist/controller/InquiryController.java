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
			int totalCount=is.totalCount();//�� ���ù��� ���� ���ؾ��Ѵ�
			int pageScale=is.pageScale();//��ȭ�鿡 ������ ���ù��Ǽ� 10��
			int totalPage=is.totalPage(totalCount);//��ü ���ù��� �����ֱ� ���� ����������
			if(ipsvo.getCurrentPage() == 0) {//web parameter�� ���� ������ 
				ipsvo.setCurrentPage(1);//1������ ��ȸ�ؾ� �ϴϱ� 1�� ����
			}
			int startNum=is.startNum(ipsvo.getCurrentPage());//���۹�ȣ
			int endNum=is.endNum(startNum);//����ȣ
			
			ipsvo.setStartNum(startNum);
			ipsvo.setEndNum(endNum);
			
			List<InquiryList> inquiryList=is.searchDiaryList(ipsvo);// ����Ʈ ����� ��ȸ
			
//			String indexList=is.indexList(ipsvo.getCurrentPage(),totalPage, "list.do");
			model.addAttribute("inquiryList",inquiryList);
//			model.addAttribute("indexList",indexList);
//			model.addAttribute("pageScale",pageScale);
//			model.addAttribute("totalCount",totalCount);
			
		
		
		return "/inquiry/inquiry_board";
	}
	
}
