package kr.co.sist.dao;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.Admin;
import kr.co.sist.vo.AddAdminVO;
import kr.co.sist.vo.ModifyAdminInfoVO;

@Component
public class AdminDAO {
	
	public int updateAdminInfo(ModifyAdminInfoVO maiVO) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult = ss.update("updateAdminInfo", maiVO);
		ss.commit();
		ss.close();
		
		return sqlResult;
	}//updateAdminInfo
	
	
	public List<Admin> selectAdminList(){
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		List<Admin> list = ss.selectList("selectAdminList");
		ss.close();
		
		return list;
	}//selectAdminList
	
	
	public int insertAdmin(AddAdminVO aaVO) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult = ss.insert("insertAdmin", aaVO);
		ss.commit();
		ss.close();
		return sqlResult;
	}//insertAdmin
	
	
	public int updateAuthority(String admin_id) {
		SqlSession ss = PropofolSqlSessionFactory.getInstance().getSqlSessionFactory().openSession();
		int sqlResult = ss.update("updateAuthority", admin_id);
		ss.commit();
		ss.close();
		return sqlResult;
	}//updateAuthority
	
}//Class
