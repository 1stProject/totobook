package totoBook.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Page;
import totoBook.store.PageStore;
import totoBook.store.mapper.PageMapper;

public class PageStoreLogic implements PageStore{
	
	private SqlSessionFactory factory;
	
	public PageStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public void insertPages(List<Page> pages) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			PageMapper mapper = session.getMapper(PageMapper.class);
			
			mapper.insertPages(pages);
		} finally {
			session.close();
		}
	}

	@Override
	public void updatePages(List<Page> pages) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deletePages(String bookId) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Page> selectPagesByBookId(String bookId) {
		// TODO Auto-generated method stub
		return null;
	}

}
