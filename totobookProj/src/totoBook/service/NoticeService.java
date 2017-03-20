package totoBook.service;

import totoBook.domain.Post;

public interface NoticeService {
	void registerNotice(Post post);
	Post findNoticeById(String noticeId);
	void modifyNotice(Post post);
	void removeNotice(String noticeId);
}
