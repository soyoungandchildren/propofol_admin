package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class PropofolSqlSessionFactory {
/*
 *  AdminService : id에 id1으로 강제로 넣고있는 중. Sesseion값 받는 것으로 수정.
 */
	private static PropofolSqlSessionFactory ssf;
	
	private PropofolSqlSessionFactory() {
	}
	
	public static PropofolSqlSessionFactory getInstance() {
		if(ssf == null) {
			ssf = new PropofolSqlSessionFactory();
		}
		return ssf;
	}

	public org.apache.ibatis.session.SqlSessionFactory getSqlSessionFactory() {
		
		//org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		LogFactory.useLog4JLogging();
		org.apache.ibatis.session.SqlSessionFactory ssf = null;
		Reader reader = null;
		try {
			//1. 설정용 XML로딩
			reader = Resources.getResourceAsReader("kr/co/sist/util/mybatis-config.xml");
			
			//2. MyBatis Framework 생성
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			
			//3. DB와 연동된 객체 받기
			ssf = ssfb.build(reader);
			if(reader!=null) {reader.close();}
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}//end catch
		
		return ssf;
	}//getSessionFactory
	
}//Class
