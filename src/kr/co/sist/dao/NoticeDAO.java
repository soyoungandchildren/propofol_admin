package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.SearchNotice;
import kr.co.sist.vo.SearchNoticeVO;

public class NoticeDAO {

	
	public List<SearchNotice> selectNotice(SearchNoticeVO snVO){
		List<SearchNotice> list = null;
		
		SqlSession ss = SqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		list = ss.selectList("SelectNoticeList", snVO);
		
		return list;
	}//selectNotice
	
	
//	public static void main(String[] args) {
//		NoticeDAO nDAO = new NoticeDAO();
//		SearchNoticeVO snVO = new SearchNoticeVO();
//		snVO.setStartNum(5);
//		snVO.setEndNum(10);
//		System.out.println(nDAO.selectNotice(snVO));
//	}
	
	
	
}//Class
