package kr.co.sist.controller;

import static org.springframework.web.bind.annotation.RequestMethod.GET;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.json.simple.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.co.sist.domain.InquiryDetail;
import kr.co.sist.domain.InquiryReply;
import kr.co.sist.domain.ReviewComment;
import kr.co.sist.domain.ReviewDetail;
import kr.co.sist.domain.ReviewList;
import kr.co.sist.service.InquiryService;
import kr.co.sist.service.ReviewService;
import kr.co.sist.vo.ReviewPageSetVO;

@Controller
public class ReviewController {
	
	@RequestMapping(value="review.do",method=GET)
	public String reviewList(ReviewPageSetVO rpsvo,Model model,HttpSession session) {
		if(null==session.getAttribute("id")) {
			
			return "/login/loginform";
		}
		ReviewService rs=new ReviewService();
		int totalCount=rs.reviewCnt();//총 개시물의 수를 구해야한다
		int pageScale=rs.pageScale();//한화면에 보여줄 개시물의수 10개
		int totalPage=rs.totalPage();//전체 개시물을 보여주기 위한 총페이지수
		if(rpsvo.getCurrentPage() == 0) {//web parameter에 값이 없을때 
			rpsvo.setCurrentPage(1);//1번부터 조회해야 하니까 1로 설정
		}
		if(rpsvo.getBigPage() == 0 || rpsvo.getBigPage() ==-1) {
			rpsvo.setBigPage(0);
		}
		int startNum=rs.startNum(rpsvo.getCurrentPage());//시작번호
		int endNum=rs.endNum(startNum);//끝번호
		
		
		rpsvo.setStartNum(startNum);
		rpsvo.setEndNum(endNum);
		
		List<ReviewList> list=rs.reviewList(rpsvo);
		
		
		model.addAttribute("cnt", totalCount);
		model.addAttribute("page", totalPage);
		model.addAttribute("reviewlist",list);
		model.addAttribute("admin",session.getAttribute("id"));
		model.addAttribute("auth", session.getAttribute("auth"));
	
		return "review/review_board_list";
	}
	
	@RequestMapping(value="review_read.do",method=GET)
	public String review_read(int num,Model model,HttpServletRequest request,HttpSession session ) {
		if(null==session.getAttribute("id")) {
			
			return "/login/loginform";
		}
		
		ReviewService rs=new ReviewService();
		ReviewDetail rd=rs.reviewread(num);
		int reviewCommentCnt=rs.reviewCommentCnt(num);
		List<ReviewComment> rc=rs.reviewComment(num);
		
		model.addAttribute("selectreview",rd);
		model.addAttribute("reviewCommentCnt", reviewCommentCnt);
		model.addAttribute("reviewcomment",rc );
		model.addAttribute("hiddennumber",num);
		model.addAttribute("admin",session.getAttribute("id"));
		model.addAttribute("auth", session.getAttribute("auth"));
		
		return "/review/review_selectread";
	}
	@ResponseBody
	@RequestMapping(value="delete_review.do",method=GET)
	public String reviewDelete(int deletenum) {
		JSONObject json=null;
		ReviewService rs=new ReviewService();
		
		json=rs.deletereview(deletenum);
		
		return json.toJSONString();
	}
	
	
	@ResponseBody
	@RequestMapping(value="deletecomment.do",method=GET)
	public String reviewDeleteComment(int deletenumber) {
		JSONObject json=null;
		ReviewService rs=new ReviewService();
		
		json=rs.deleteReviewComment(deletenumber);
		
		return json.toJSONString();
	}
	
	
	
}
