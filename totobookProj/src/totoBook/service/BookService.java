package totoBook.service;

import java.util.List;

import totoBook.domain.Book;

/**
 * @author juhee Kim
 * @version 1.0
 */
public interface BookService {
	
	void registerBook(Book book);
	void modifyBook(Book book);
	void removeBook(String bookId);
	List<Book> findBooksByMemberId(String memberId);
	Book findBook(String bookId);
	

}