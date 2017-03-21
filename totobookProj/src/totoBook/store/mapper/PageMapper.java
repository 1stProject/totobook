package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Page;

/**
 * @author juhee Kim
 * @version 1.0
 */ 

public interface PageMapper {
	
	void insertPages(List<Page> pages);
	void updatePages(List<Page> pages);
	void deletePages(String bookId);
	List<Page> selectPagesByBookId(String bookId);

}
