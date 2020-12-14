package common;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class SqlSessionTemplate {
	public static SqlSession getSqlSession() {
		SqlSession session =null;
		String config="mybatis-config.xml";   //xml파일명 그대로
		try {
			//mybatis-config.xml 파일과 input stream 생성
			InputStream is =Resources.getResourceAsStream(config);
			//SqlSessionFactory를 만들수 있는 팩토리빌더 생성
			SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();
			//팩토리빌더를 통해 실제 SqlSession을 만드는 SqlSessionFactory 생성
			SqlSessionFactory factory = builder.build(is);
			//SqlSession객체 생성 -> 매개변수 false는 autocommit 해제
			session = factory.openSession(false);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return session;
	}
}
