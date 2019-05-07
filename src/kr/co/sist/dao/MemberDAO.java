package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.MemberList;
import kr.co.sist.vo.SearchMemberVO;

@Component
public class MemberDAO {
	
	public List<MemberList> selectMemberList(SearchMemberVO smVO){
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		List<MemberList> list = ss.selectList("selectMemberList", smVO);
		ss.close();
		return list;
	}//selectMemberList
	
	public int selectTotalPageCount() {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int pageCount = ss.selectOne("kr.co.sist.member.selectTotalPageCount");
		ss.close();
		
		return pageCount; 
	}//selectTotalPageCount
	
}
