package totoBook.store;

import java.util.List;

import totoBook.domain.Book;

/**
 * @author juhee Kim
 * @version 1.0
 */
public interface BookStore {
	
	void insertBook(Book book);
	void updateBook(Book book);
	void deleteBook(String bookId);
	List<Book> selectBooksByMemberId(String memberId);
	Book selectBook(String bookId);
	

}