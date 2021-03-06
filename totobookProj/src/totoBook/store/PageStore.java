package totoBook.store;

import java.util.List;

import totoBook.domain.Page;

/**
 * @author juhee Kim
 * @version 1.0
 */
public interface PageStore {
	
	void insertPage(Page pages);
	void deletePages(String bookId);
	List<Page> selectPagesByBookId(String bookId);

}