package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.NoticeDetail;
import kr.co.sist.domain.SearchNotice;
import kr.co.sist.vo.ModifyNoticeVO;
import kr.co.sist.vo.SearchNoticeVO;
@Component
public class NoticeDAO {

	
	public List<SearchNotice> selectNotice(SearchNoticeVO snVO){
		List<SearchNotice> list = null;
		
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		list = ss.selectList("SelectNoticeList", snVO);
		ss.close();
		
		return list;
	}//selectNotice
	
	
	public int selectTotalPageCount() {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int pageCount = ss.selectOne("SelectTotalPageCount");
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
	
	
}//Class
