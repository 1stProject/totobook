package totoBook.store.logic;

import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Option;
import totoBook.store.OptionStore;

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
