package totoBook.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Option;
import totoBook.store.OptionStore;
import totoBook.store.mapper.ProductMapper;

public class OptionStoreLogic implements OptionStore{

	
	private SqlSessionFactory factory;
	
	public OptionStoreLogic(){
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public Option selectOption(String product_id) {
		return null;
	}
	
	
	@Override
	public void insertOption(Option option) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void modifyOption(Option option) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void removeOption(Option option) {
		// TODO Auto-generated method stub
		
	}
	
	
}
