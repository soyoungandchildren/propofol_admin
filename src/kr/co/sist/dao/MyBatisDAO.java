package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.InquiryDetail;
import kr.co.sist.domain.InquiryList;
import kr.co.sist.domain.InquiryReply;
import kr.co.sist.domain.LoginCheckResult;
import kr.co.sist.vo.InquiryPageSetVO;
import kr.co.sist.vo.InquiryReplyVO;
import kr.co.sist.vo.LoginCheckVO;

@Component
public class MyBatisDao {

	private static MyBatisDao mb_dao;
	
	private MyBatisDao() {
	} // MyBatisDAO
	
	public static MyBatisDao getInstance() {
		if(mb_dao == null) {
			mb_dao = new MyBatisDao();
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		} // end if
		return mb_dao;
	} // getInstance
	
	public synchronized SqlSessionFactory getSessionFactory() {
		SqlSessionFactory ssf = null;
		
		try {
			// 1. ������ xml �ε�
			Reader reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis_config.xml");
			// 2. MyBatis Framework ����
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			// 3. DB�� ������ ��ü �ޱ�
			ssf = ssfb.build(reader);
			if(reader != null ) {
				reader.close();
			} // end if
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return ssf;
	} // getSessionFactory
	
	public LoginCheckResult idCheck(LoginCheckVO lcvo) {
		SqlSession ss=MyBatisDao.getInstance().getSessionFactory().openSession();
		LoginCheckResult lcr=null;
		try {
		lcr=ss.selectOne("logincheck",lcvo);
		System.out.println(lcr);	
		if(null==lcr) {
				new LoginCheckResult();
			}
		}
		catch(Exception npe) {
			System.out.println("�γ� �ϱ���");
			System.out.println("======="+lcr);
			System.out.println(lcr.getName()+"///"+lcr.getAuthority());
			
			
		}finally {
			ss.close();
		}
	//	System.out.println(lcr.getName()+" /DAO "+lcr.getAuthority());
		
		
		
		return lcr;
		
	}
	public int selectTotalCount() {
		SqlSession ss=getSessionFactory().openSession();
		int cnt=ss.selectOne("diaryTotalCnt");
		ss.close();
		return cnt;
	}
	public List<InquiryList>selectList(InquiryPageSetVO ipsvo){
		List<InquiryList> list=null;
		SqlSession ss=getSessionFactory().openSession();
		list=ss.selectList("inquiryList", ipsvo);
		ss.close();
		return list;
	}
	
	public InquiryDetail selectInquiryDetail(int num) {
		
		InquiryDetail dd=null;
		SqlSession ss=getSessionFactory().openSession();
		dd=ss.selectOne("inquiryDetail", num);
		ss.close();
		return dd;
	}
	
	public int insertReply(InquiryReplyVO irvo) {
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.update("insertReply",irvo);
		if(cnt==1) {
			ss.commit();
		}
		ss.close();
		return cnt;
	}
	
	public InquiryReply readReply(int num) {
		InquiryReply ir=null;
		SqlSession ss =getSessionFactory().openSession();
		ir=ss.selectOne("readreply", num);
		ss.close();
		return ir;
	}
	public int deleteUserInquiry(int num) {
		int cnt=0;
		SqlSession ss=getSessionFactory().openSession();
		cnt=ss.delete("deleteUserInquiry",num);
		if(cnt==1) {
			ss.commit();
		}
		ss.close();
		
		return cnt;
	}
	
	
	
/*	public static void main(String[] args) {
		MyBatisDao mm=new MyBatisDao();
		System.out.println(mm.readReply(23)); 
	}
	*/
} // class