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
	public String insertPrint(Print print) {
		SqlSession session = factory.openSession();
		String printId = "";
		try {
			PrintMapper mapper = session.getMapper(PrintMapper.class);
			mapper.insertPrint(print);
			printId = print.getPrintId();
			session.commit();
		} finally {
			session.close();
		}
		return printId;
	}

	@Override
	public void deletePrint(String printId) {
		SqlSession session = factory.openSession();
		try {
			PrintMapper mapper = session.getMapper(PrintMapper.class);
			mapper.deletePrint(printId);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Override
	public List<Print> selectPrintsByMemberId(String memberId) {
		SqlSession session = factory.openSession();
		List<Print> prints = null;
		try {
			PrintMapper mapper = session.getMapper(PrintMapper.class);
			prints = mapper.selectPrintsByMemberId(memberId);
		} finally {
			session.close();
		}
		return prints;
	}
	@Override
	public Print selectPrintByPrintId(String printId) {
		SqlSession session = factory.openSession();
		Print print = null;
		try{
			PrintMapper mapper = session.getMapper(PrintMapper.class);
			print = mapper.selectPrintByPrintId(printId);
		} finally {
			session.close();
		}
		return print;
	}
}
