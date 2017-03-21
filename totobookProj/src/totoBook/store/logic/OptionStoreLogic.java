package totoBook.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Option;
import totoBook.store.OptionStore;
import totoBook.store.mapper.ProductMapper;

/**
 * @author
 * @version 1.0
 */
public class OptionStoreLogic implements OptionStore{

	
	private SqlSessionFactory factory;
	
	public OptionStoreLogic(){
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	
	
	
	@Override
	public List<Option> selectOptions(String productid) {
		SqlSession session = factory.openSession();
		Option option = new Option();
		List<Option> list = new ArrayList<>();
		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			list = mapper.selectOption(productid);
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
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.insertOption(option);
			session.commit();
		} finally {
			session.close();
		}
	}
	
	@Override
	public void modifyOption(Option option) {
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.modifyOption(option);
			session.commit();
		} finally {
			session.close();
		}

	}
	
	@Override
	public void deleteOption(Option option) {
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.deleteOption(option);
			;
			session.commit();
		} finally {
			session.close();
		}

	}	
	
}
