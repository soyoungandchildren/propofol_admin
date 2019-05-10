package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.co.sist.domain.ReviewList;
import kr.co.sist.service.ReviewService;
import kr.co.sist.vo.ReviewPageSetVO;

@Controller
public class ReviewController {

	
	@RequestMapping(value="review.do",method=GET)
	public String reviewList(ReviewPageSetVO rpsvo,Model model) {
		ReviewService rs=new ReviewService();
		int cnt=0;
		int totalCount=rs.reviewCnt();//�� ���ù��� ���� ���ؾ��Ѵ�
		int pageScale=rs.pageScale();//��ȭ�鿡 ������ ���ù��Ǽ� 10��
		int totalPage=rs.totalPage();//��ü ���ù��� �����ֱ� ���� ����������
		if(rpsvo.getCurrentPage() == 0) {//web parameter�� ���� ������ 
			rpsvo.setCurrentPage(1);//1������ ��ȸ�ؾ� �ϴϱ� 1�� ����
		}
		if(rpsvo.getBigPage() == 0 || rpsvo.getBigPage() ==-1) {
			rpsvo.setBigPage(0);
		}
		int startNum=rs.startNum(rpsvo.getCurrentPage());//���۹�ȣ
		int endNum=rs.endNum(startNum);//����ȣ
		
		
		rpsvo.setStartNum(startNum);
		rpsvo.setEndNum(endNum);
		
		
		cnt=rs.reviewCnt();
		List<ReviewList> list=rs.reviewList(rpsvo);
		
		
		System.out.println(list.size());
		model.addAttribute("cnt", cnt);
		model.addAttribute("reviewlist",list);
	
		return "review/review_board_list";
	}
	
}
