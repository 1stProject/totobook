package totoBook.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Print;
import totoBook.store.PrintStore;
import totoBook.store.mapper.PrintMapper;

/**
 * @author
 * @version 1.0
 */
public class PrintStoreLogic implements PrintStore {
	private SqlSessionFactory factory;
	
	public PrintStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public void insertPrint(Print print) {
		SqlSession session = factory.openSession();
		try {
			PrintMapper mapper = session.getMapper(PrintMapper.class);
			mapper.insertPrint(print);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deletePrint(String printId) {
		
	}
	
	@Override
	public List<Print> selectPrintsByUserId(String userId) {
		SqlSession session = factory.openSession();
		List<Print> prints = null;
		try {
			PrintMapper mapper = session.getMapper(PrintMapper.class);
			prints = mapper.selectPrintsByUserId(userId);
		} finally {
			session.close();
		}
		return prints;
	}

}
