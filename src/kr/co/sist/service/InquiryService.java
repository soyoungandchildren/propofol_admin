package kr.co.sist.service;

import java.util.List;

import org.json.simple.JSONObject;

import kr.co.sist.dao.MyBatisDao;
import kr.co.sist.domain.InquiryDetail;
import kr.co.sist.domain.InquiryList;
import kr.co.sist.domain.InquiryReply;
import kr.co.sist.vo.InquiryPageSetVO;
import kr.co.sist.vo.InquiryReplyVO;



public class InquiryService {

	
	 private MyBatisDao mb_dao;
	   public InquiryService() {
	      mb_dao= MyBatisDao.getInstance();
	   }//mb_dao
	   
	   /**
	    * 총 게시물의 수 얻기
	    * @return
	    */
	   public int totalCount() {
	      int cnt=0;
	      cnt=mb_dao.selectTotalCount();
	      return cnt;
	   }//totalCount
	   
	    /**
	    * 한 페이지에 보여줄 게시물의 수
	    * @return
	    */
	   public int pageScale() {
	       int pageScale=10;
	       return pageScale;
	    }//pageScale
	    
	    /**
	     * 모든 게시물을 보여주기 위한 페이지 수
	    * @param totalCount
	    * @return
	    */
	   public int totalPage() {
		   int tempTotalCount=totalCount();
	      int totalPage = tempTotalCount/pageScale();
	      if(tempTotalCount % pageScale() !=0){
	         totalPage++;
	      }//end if
	      return totalPage;
	    }//totalPage
	    
	    /**
	     * 선택한 인덱스 리스트에서 조회할 시작번호
	     * @param currentPage
	     * @return
	     */
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
	    
	    public List<InquiryList> searchDiaryList(InquiryPageSetVO ipsvo){
	    	List<InquiryList> list =null;
	    	list = mb_dao.selectList(ipsvo);
			//글의 제목은 24자 까지만 보여준다
			
				String subject="";
				String writer="";
				for(int i=0; i<list.size();i++) {
					
					subject=list.get(i).getSubject();
					writer=list.get(i).getUser_id();
					if(subject.length()>25) {
						subject=subject.substring(0, 23)+".......";
						list.get(i).setSubject(subject);
					}
					if(writer.length()>25) {
						writer=writer.substring(0, 23)+"**";
						list.get(i).setUser_id(writer);
					}
				}
				
	    	return list;
	    }
	    
	    
	    
	    /** 선택한 글 읽어오기
	     * @param num
	     * @return
	     */
	    public InquiryDetail searchSelectInquiry(int num) {
	    	InquiryDetail dd=mb_dao.selectInquiryDetail(num);
	    	return dd;
	    }
	    public InquiryReply selectReadReply(int num) {
	    	InquiryReply ir=mb_dao.readReply(num);
	    	
	    	return ir;
	    }
	    
	    public JSONObject delete(int num) {
	    	JSONObject json = new JSONObject();
	        int cnt=0;
	        cnt=mb_dao.deleteUserInquiry(num);
	        
	        json.put("deleteresult", cnt==1);
	    	return json;
	    }
	    public JSONObject writeReply(InquiryReplyVO irvo) {
	        JSONObject json = new JSONObject();
	        int cnt = mb_dao.insertReply(irvo);
	        
	        json.put("result", cnt == 1); // bbs_read.jsp 의 result 와 동일한 key명을 줘 일치시켜주고 value는 boolean형을 넣는다. (true | false)
	        
	        return json;
	     } // writeReply
	    
	   public JSONObject updatere(int num) {
		   JSONObject json = new JSONObject();
		   int cnt= mb_dao.updatere(num);
		   
		   json.put("deletere", cnt==1);
		   
		   return json;
	   }

	    
	    
/*	    public static void main(String[] args) {
			InquiryService is=new InquiryService();
			System.out.println(is.totalCount()    );
			System.out.println(is.pageScale()    );
			System.out.println(is.totalPage()    );
//			System.out.println(is.searchDiaryList() );
			
			
//			is.startNum(currentPage);
//			is.endNum(startNum);
			
		}*/
	    
	    
	    
}
