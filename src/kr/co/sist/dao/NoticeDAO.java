package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.NoticeDetail;
import kr.co.sist.domain.NoticeList;
import kr.co.sist.vo.ModifyNoticeVO;
import kr.co.sist.vo.SearchNoticeVO;
import kr.co.sist.vo.WriteNoticeVO;
@Component
public class NoticeDAO {

	
	public List<NoticeList> selectNotice(SearchNoticeVO snVO){
		List<NoticeList> list = null;
		
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		list = ss.selectList("SelectNoticeList", snVO);
		ss.close();
		
		return list;
	}//selectNotice
	
	
	public int selectTotalPageCount() {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int pageCount = ss.selectOne("kr.co.sist.notice.selectTotalPageCount");
		ss.close();
		
		return pageCount; 
	}//selectTotalPageCount
	
	
	public NoticeDetail selectNoticeDetail(int notice_no) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		NoticeDetail nd = ss.selectOne("selectNoticeDetail", notice_no);
		ss.close();
		
		return nd;
	}//selectNoticeDetail
	
	
	public int updateNoticeDetail(ModifyNoticeVO mnVO) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult =  ss.update("updateNoticeDetail", mnVO);
		ss.commit();
		ss.close();
		return sqlResult;
	}//updateNoticeDetail
	
	
	public int insertNotice(WriteNoticeVO wnVO) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult = ss.insert("insertNotice", wnVO);
		ss.commit();
		ss.close();
		
		return sqlResult;
	}//insertNotice
	
	
	public int deleteNotice(int notice_no) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult = ss.delete("deleteNotice", notice_no);
		ss.commit();
		ss.close();
		
		return sqlResult;
	}//
	
	
}//Class
