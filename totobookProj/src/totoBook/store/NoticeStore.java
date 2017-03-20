package totoBook.store;

import java.util.List;

import totoBook.domain.Post;

public interface NoticeStore {
	List<Post> selectAllNotice();
	Post selectNoticeById(String noticeId);
	void updateNotice(Post post);
	void deleteNotice(String noticeId);
}
