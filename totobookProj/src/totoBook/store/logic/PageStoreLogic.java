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
	public void insertPage(Page page) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			PageMapper mapper = session.getMapper(PageMapper.class);
			
				mapper.insertPage(page);
			session.commit();
		} finally {
			session.close();
		}
	}

	@Override
	public void deletePages(String bookId) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			PageMapper mapper = session.getMapper(PageMapper.class);
			
			mapper.deletePages(bookId);
			session.commit();
		} finally {
			session.close();
		}
		
	}

	@Override
	public List<Page> selectPagesByBookId(String bookId) {
		SqlSession session = null;
		List<Page> pages = null;
		
		try {
			session = factory.openSession();
			PageMapper mapper = session.getMapper(PageMapper.class);
			
			pages = mapper.selectPagesByBookId(bookId);
		} finally {
			session.close();
		}
		return pages;
	}

}
