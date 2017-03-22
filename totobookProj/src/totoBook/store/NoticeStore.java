package totoBook.store;

import java.util.List;

import totoBook.domain.Post;

/**
 * @author
 * @version 1.0
 */
public interface NoticeStore {
	List<Post> selectAllNotice();
	Post selectNoticeById(String noticeId);
	void updateNotice(Post post);
	void deleteNotice(String noticeId);
	void insertNotice(Post post);
}
