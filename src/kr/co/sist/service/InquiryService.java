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
	    * �� �Խù��� �� ���
	    * @return
	    */
	   public int totalCount() {
	      int cnt=0;
	      cnt=mb_dao.selectTotalCount();
	      return cnt;
	   }//totalCount
	   
	    /**
	    * �� �������� ������ �Խù��� ��
	    * @return
	    */
	   public int pageScale() {
	       int pageScale=10;
	       return pageScale;
	    }//pageScale
	    
	    /**
	     * ��� �Խù��� �����ֱ� ���� ������ ��
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
	     * ������ �ε��� ����Ʈ���� ��ȸ�� ���۹�ȣ
	     * @param currentPage
	     * @return
	     */
	    public int startNum(int currentPage) {
	      int startNum=1;
	         startNum=currentPage*pageScale()-pageScale()+1;
	       return startNum;
	    }//startNum
	    
	    /**
	     * ����ȯ �ε��� ����Ʈ���� ��ȸ;�� ����ȣ
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
			//���� ������ 24�� ������ �����ش�
			
				/*Diary dl_vo=null;
				String subject="";
				String writer="";
				for(int i=0; i<list.size();i++) {
					dl_vo=list.get(i);
					subject=dl_vo.getSubject();
					writer=dl_vo.getWriter();
					if(subject.length()>25) {
						subject=subject.substring(0, 23)+".......";
						dl_vo.setSubject(subject);
					}
					if(writer.length()>25) {
						writer=writer.substring(0, 23)+"**";
						dl_vo.setWriter(writer);
					}
				}*/
				
	    	return list;
	    }
	    
	    
	    
	   // ���� �Խ����� ������ �ε��� ����
	    /**
	     * �ε��� ����Ʈ[1][2][3][4]
	     * @param current_page
	     * @param total_page
	     * @param list_url
	     * @return
	     */
/*	    public String indexList(int current_page, int total_page, String list_url) {
	    int pagenumber; // ȭ�鿡 ������ ������ �ε��� ��
	    int startpage; // ȭ�鿡 ������ ���������� ��ȣ
	    int endpage; // ȭ�鿡 ������ ������������ ��ȣ
	    int curpage; // �̵��ϰ��� �ϴ� ������ ��ȣ

	    String strList=""; // ���ϵ� ������ �ε��� ����Ʈ

	    pagenumber = 10; // �� ȭ���� ������ �ε��� �� 

	    // ���� ��������ȣ ���ϱ�
	    startpage = ((current_page - 1) / pagenumber) * pagenumber + 1;

	    // ������ ��������ȣ ���ϱ�
	    endpage = (((startpage - 1) + pagenumber) / pagenumber) * pagenumber;

	    // �� ������ ���� ���� ������������ ��ȣ���� ������� 

	    // �� ������ ���� ������������ ��ȣ�� ��


	    if (total_page <= endpage){
	       endpage = total_page;
	    }//end if

	    // ù��° ������ �ε��� ȭ���� �ƴѰ��
	    if ( current_page > pagenumber) {
	       curpage = startpage - 1; // ���������� ��ȣ���� 1 ���� �������� �̵�
	       strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+">&lt;&lt;</a> ]";
	    }else{
	       strList = strList + "[<<]";
	    }

	    strList = strList + " ... ";

	    // ���������� ��ȣ���� ������������ ��ȣ���� ȭ�鿡 ǥ��
	    curpage = startpage;

	    while (curpage <= endpage){
	       if (curpage == current_page) {
	          strList = strList + "["+current_page+"]";
	       } else {
	          strList = strList +"[ <a href="+list_url+"?currentPage="+curpage+">"+curpage+"</a> ]";
	       }//end else

	       curpage++;
	    }//end while

	    strList = strList + " ... ";

	    // �ڿ� �������� �� �ִ°��
	    if ( total_page > endpage) {
	       curpage = endpage + 1; 
	       strList = strList + "[ <a href="+list_url+"?currentPage="+curpage+">&gt;&gt;</a> ]";
	    }else{
	       strList = strList + "[>>]";
	    }//end else

	    return strList;
	    }//indexList
	    
	    */
	    /** ������ �� �о����
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
	    /*public List<DiaryReply> searchReplyList(int num){
	    	List<DiaryReply> list =null;
	    	list = mb_dao.selectReplyList(num);
						
	    	return list;
	    }*/
	    
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
	        
	        json.put("result", cnt == 1); // bbs_read.jsp �� result �� ������ key���� �� ��ġ�����ְ� value�� boolean���� �ִ´�. (true | false)
	        
	        return json;
	     } // writeReply

	    
	    
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
