package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Post;
import totoBook.service.NoticeService;
import totoBook.store.NoticeStore;
import totoBook.store.logic.NoticeStoreLogic;

public class NoticeServiceLogic implements NoticeService{

	@Override
	public void registerNotice(Post post) {
		NoticeStore store = new NoticeStoreLogic();
		store.insertNotice(post);
		
	}

	@Override
	public Post findNoticeById(String noticeId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyNotice(Post post) {
		// TODO Auto-generated method stub
		
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
