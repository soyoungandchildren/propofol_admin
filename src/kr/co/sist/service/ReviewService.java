package kr.co.sist.service;

import java.util.List;

import kr.co.sist.dao.MyBatisDao;
import kr.co.sist.domain.ReviewList;
import kr.co.sist.vo.ReviewPageSetVO;

public class ReviewService {
	
	 private MyBatisDao mb_dao;
	 
	public ReviewService() {
		mb_dao=MyBatisDao.getInstance();
	}
	 
	 public int reviewCnt() {
		 int cnt=0;
		 cnt=mb_dao.reviewCnt();
		 
		 return cnt;
	 }
	 
	 public int pageScale() {
	       int pageScale=10;
	       return pageScale;
	 }//pageScale
	 public int totalPage() {
		   int tempTotalCount=reviewCnt();
	      int totalPage = tempTotalCount/pageScale();
	      if(tempTotalCount % pageScale() !=0){
	         totalPage++;
	      }//end if
	      return totalPage;
	    }//totalPage
	 
	 public int startNum(int currentPage) {
	      int startNum=1;
	         startNum=currentPage*pageScale()-pageScale()+1;
	       return startNum;
	    }//startNum
	    
	    /**
	     * 선택환 인덱스 리스트에서 조회;할 끝번호
	     * @param startNum
	     * @return
	     */
	    public int endNum(int startNum) {
	       int endNum = startNum+pageScale()-1;
	       return endNum;
	    }//endNum
	 
	 
	 
	 public List<ReviewList> reviewList(ReviewPageSetVO rpsvo){
		 List<ReviewList> list=null;
		 list=mb_dao.reviewList(rpsvo);
		 
		 
		 return list;
	 }
	

}
