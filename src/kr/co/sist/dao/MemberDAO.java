package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.MemberInfo;
import kr.co.sist.domain.MemberList;
import kr.co.sist.vo.ChangeBanStatusVO;
import kr.co.sist.vo.ModifyMemberInfoVO;
import kr.co.sist.vo.SearchMemberVO;

@Component
public class MemberDAO {
	
	public List<MemberList> selectMemberList(SearchMemberVO smVO){
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		List<MemberList> list = ss.selectList("selectMemberList", smVO);
		ss.close();
		return list;
	}//selectMemberList
	
	public int selectTotalPageCount(SearchMemberVO smVO) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int pageCount = ss.selectOne("kr.co.sist.member.selectTotalPageCount", smVO);
		ss.close();
		return pageCount; 
	}//selectTotalPageCount
	
	public MemberInfo selectMemberInfo(String user_id) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		MemberInfo mi = ss.selectOne("selectMemberInfo", user_id);
		ss.close();
		return mi;
	}//selectMemberInfo
	
	public int updateBanStatus(ChangeBanStatusVO cbsVO) {
		SqlSession ss= PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult = ss.update("updateBanStatus", cbsVO);
		ss.commit();
		ss.close();
		return sqlResult;
	}//updateBanStatus
	
	public int updateMemberInfo(ModifyMemberInfoVO mmiVO) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult = ss.update("updateMemberInfo", mmiVO);
		ss.commit();
		ss.close();
		return sqlResult;
	}//updateMemberInfo
	
}
