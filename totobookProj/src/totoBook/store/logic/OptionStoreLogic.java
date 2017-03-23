package totoBook.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Option;
import totoBook.store.OptionStore;
import totoBook.store.mapper.OptionMapper;

/**
 * @author
 * @version 1.0
 */
public class OptionStoreLogic implements OptionStore{

	private SqlSessionFactory factory;

	public OptionStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	
	@Override
	public List<Option> selectOptions(String productId) {
		SqlSession session = factory.openSession();
		List<Option> list = new ArrayList<>();
		try {
			OptionMapper mapper = session.getMapper(OptionMapper.class);
			list = mapper.selectOptions("1");
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}
	
	@Override
	public void insertOption(Option option) {
		SqlSession session = factory.openSession();
		try {
			OptionMapper mapper = session.getMapper(OptionMapper.class);
			mapper.insertOption(option);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void updateOption(Option option) {
		SqlSession session = factory.openSession();

		try {
			OptionMapper mapper = session.getMapper(OptionMapper.class);
			mapper.updateOption(option);
			session.commit();
		} finally {
			session.close();
		}

	}
	
	@Override
	public void deleteOption(String productId) {
		SqlSession session = factory.openSession();

		try {
			OptionMapper mapper = session.getMapper(OptionMapper.class);
			mapper.deleteOption(productId);
			session.commit();
		} finally {
			session.close();
		}

	}	
	
}
