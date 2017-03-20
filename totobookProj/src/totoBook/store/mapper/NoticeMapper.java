package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Book;
import totoBook.domain.Post;

public interface NoticeMapper {

	List<Post> selectAllNotice();
	Post selectNoticeById(String noticeId);
	void updateNotice(Post post);
	void deleteNotice(String noticeId);
}
