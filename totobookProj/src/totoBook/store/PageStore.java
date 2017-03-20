package totoBook.store;

import java.util.List;

import totoBook.domain.Page;

public interface PageStore {
	
	void insertPages(List<Page> pages);
	void updatePages(List<Page> pages);
	void deletePages(String bookId);
	List<Page> selectPagesByBookId(String bookId);

}