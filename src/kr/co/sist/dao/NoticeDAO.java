package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.SearchNotice;
import kr.co.sist.vo.SearchNoticeVO;
@Component
public class NoticeDAO {

	
	public List<SearchNotice> selectNotice(SearchNoticeVO snVO){
		List<SearchNotice> list = null;
		
		SqlSession ss = SqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		list = ss.selectList("SelectNoticeList", snVO);
		ss.close();
		
		return list;
	}//selectNotice
	
	
	public int selectTotalPageCount() {
		SqlSession ss = SqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int pageCount = ss.selectOne("SelectTotalPageCount");
		ss.close();
		
		return pageCount; 
	}//selectTotalPageCount
	
	
}//Class
