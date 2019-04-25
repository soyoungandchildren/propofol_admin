package kr.co.sist.dao;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionFactory {

	private static SqlSessionFactory ssf;
	
	private SqlSessionFactory() {
	}
	
	public static SqlSessionFactory getInstance() {
		if(ssf == null) {
			ssf = new SqlSessionFactory();
		}
		return ssf;
	}

	public org.apache.ibatis.session.SqlSessionFactory getSqlSessionFactory() {
		
		//org.apache.ibatis.logging.LogFactory.useLog4JLogging();
		LogFactory.useLog4JLogging();
		org.apache.ibatis.session.SqlSessionFactory ssf = null;
		Reader reader = null;
		try {
			//1. ������ XML�ε�
			reader = Resources.getResourceAsReader("kr/co/sist/util/mybatis-config.xml");
			
			//2. MyBatis Framework ����
			SqlSessionFactoryBuilder ssfb = new SqlSessionFactoryBuilder();
			
			//3. DB�� ������ ��ü �ޱ�
			ssf = ssfb.build(reader);
			if(reader!=null) {reader.close();}
			
		}catch(IOException ioe) {
			ioe.printStackTrace();
		}//end catch
		
		return ssf;
	}//getSessionFactory
	
}//Class
