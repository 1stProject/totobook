package totoBook.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Book;
import totoBook.store.BookStore;
import totoBook.store.mapper.BookMapper;

public class BookStoreLogic implements BookStore{
	
	private SqlSessionFactory factory;
	
	public BookStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public void insertBook(Book book) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			mapper.insertBook(book);
		} finally {
			session.close();
		}
	}

	@Override
	public void updateBook(Book book) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			mapper.updateBook(book);
		} finally {
			session.close();
		}
	}

	@Override
	public void deleteBook(String bookId) {
		SqlSession session = null;
		
		try {
			session = factory.openSession();
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			mapper.deleteBook(bookId);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Book> selectBooksByMemberId(String memberId) {
		SqlSession session = null;
		List<Book> books = null;
		
		try {
			session = factory.openSession();
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			 books = mapper.selectBooksByMemberId(memberId);
		} finally {
			session.close();
		}
		return books;
	}

	@Override
	public Book selectBook(String bookId) {
		SqlSession session = null;
		Book book = null;
		
		try {
			session = factory.openSession();
			BookMapper mapper = session.getMapper(BookMapper.class);
			
			 book = mapper.selectBook(bookId);
		} finally {
			session.close();
		}
		return book;
	}

}
