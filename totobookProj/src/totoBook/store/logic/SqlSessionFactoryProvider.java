package totoBook.store.logic;

import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * @author juhee Kim
 * @version 1.0
 */
public class SqlSessionFactoryProvider {

	private static final String resource = "totoBook/store/config.xml";

	private static SqlSessionFactory factory;

	public static SqlSessionFactory getSqlSessionFactory() {
		if (factory == null) {
			createSqlSessionFactory();
		}
		return factory;
	}

	private static void createSqlSessionFactory() {
		try {
			Reader reader = Resources.getResourceAsReader(resource);
			factory = new SqlSessionFactoryBuilder().build(reader);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
//	흠.. 왜 안올라가는지 잘 모르겠음.
}
