package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Page;

public interface PageMapper {
	
	void insertPages(List<Page> pages);
	void updatePages(List<Page> pages);
	void deletePages(String bookId);
	List<Page> selectPagesByBookId(String bookId);

}
