package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Book;
import totoBook.service.BookService;
import totoBook.store.BookStore;
import totoBook.store.PageStore;
import totoBook.store.logic.BookStoreLogic;
import totoBook.store.logic.PageStoreLogic;

/**
 * @author juhee Kim
 * @version 1.0
 */

public class BookServiceLogic implements BookService{
	
	private BookStore bookStore;
	private PageStore pageStore;
	
	public BookServiceLogic() {
		bookStore = new BookStoreLogic();
		pageStore = new PageStoreLogic();
	}
	
	@Override
	public void registerBook(Book book) {
		bookStore.insertBook(book);
		pageStore.insertPages(book.getPages());
	}

	@Override
	public void modifyBook(Book book) {
		bookStore.updateBook(book);
		pageStore.updatePages(book.getPages());
	}

	@Override
	public void removeBook(String bookId) {
		pageStore.deletePages(bookId);
		bookStore.deleteBook(bookId);
	}

	@Override
	public List<Book> findBooksByMemberId(String memberId) {
		return bookStore.selectBooksByMemberId(memberId);
	}

	@Override
	public Book findBook(String bookId) {
		Book book = bookStore.selectBook(bookId);
		book.setPages(pageStore.selectPagesByBookId(bookId));
		
		return book;
	}

}
