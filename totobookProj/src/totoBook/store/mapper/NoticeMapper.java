package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Book;
import totoBook.domain.Post;

/**
 * @author
 * @version 1.0
 */
public interface NoticeMapper {

	List<Post> selectAllNotice();
	Post selectNoticeById(String noticeId);
	void updateNotice(Post post);
	void deleteNotice(String noticeId);
	void insertNotice(Post post);
}
