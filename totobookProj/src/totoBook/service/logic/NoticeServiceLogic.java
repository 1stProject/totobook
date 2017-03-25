package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Post;
import totoBook.service.NoticeService;
import totoBook.store.NoticeStore;
import totoBook.store.logic.NoticeStoreLogic;

public class NoticeServiceLogic implements NoticeService {

	@Override
	public void registerNotice(Post post) {
		NoticeStore store = new NoticeStoreLogic();
		System.out.println(post.getImageAddressPath());
		System.out.println(post.getMember().getMemberId());
		store.insertNotice(post);

	}

	@Override
	public Post findNoticeById(String noticeId) {
		NoticeStore store = new NoticeStoreLogic();
		Post post = store.selectNoticeById(noticeId);
		return post;
	}

	@Override
	public void modifyNotice(Post post) {
		NoticeStore store = new NoticeStoreLogic();
		store.updateNotice(post);

	}

	@Override
	public void removeNotice(String noticeId) {
		NoticeStore store = new NoticeStoreLogic();
		store.deleteNotice(noticeId);

	}

	@Override
	public List<Post> findAllNotice() {
		NoticeStore store = new NoticeStoreLogic();
		List<Post> list = store.selectAllNotice();
		return list;
	}

}
