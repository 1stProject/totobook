package totoBook.service;

import totoBook.domain.Post;

/**
 * @author
 * @version 1.0
 */
public interface NoticeService {
	void registerNotice(Post post);
	Post findNoticeById(String noticeId);
	void modifyNotice(Post post);
	void removeNotice(String noticeId);
}
