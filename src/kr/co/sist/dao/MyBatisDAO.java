package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.stereotype.Component;

import kr.co.sist.domain.LoginCheckResult;
import kr.co.sist.vo.LoginCheckVO;

@Component
public class MyBatisDAO {

	private static MyBatisDAO mb_dao;
	
	private MyBatisDAO() {
	} // MyBatisDAO
	
	public static MyBatisDAO getInstance() {
		if(mb_dao == null) {
			mb_dao = new MyBatisDAO();
			org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		} // end if
		return mb_dao;
	} // getInstance
	
	public synchronized SqlSessionFactory getSessionFactory() {
		SqlSessionFactory ssf = null;
		
		try {
			// 1. 설정용 xml 로딩
			Reader reader = Resources.getResourceAsReader("kr/co/sist/dao/mybatis_config.xml");
			// 2. MyBatis Framework 생성
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			// 3. DB와 연동된 객체 받기
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
		SqlSession ss=MyBatisDAO.getInstance().getSessionFactory().openSession();
		kr.co.sist.domain.LoginCheckResult cnt=ss.selectOne("logincheck",lcvo);
		ss.close();
		System.out.println(cnt.getName()+" / "+cnt.getAuthority());
		
		return cnt;
		
	}	
	
/*	public static void main(String[] args) {
		MyBatisDAO mm=new MyBatisDAO();
		LoginCheckVO dd=new LoginCheckVO("sso",	"1234");
		mm.idCheck(dd); 
	}*/
	
} // class
