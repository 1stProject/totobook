package totoBook.service;

import java.util.List;

import totoBook.domain.Book;

public interface BookService {
	
	void registerBook(Book book);
	void modifyBook(Book book);
	void removeBook(String bookId);
	List<Book> findBooksMyMemberId(String memberId);
	Book findBook(String bookId);
	

}