package totoBook.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Post;
import totoBook.store.NoticeStore;
import totoBook.store.mapper.NoticeMapper;
import totoBook.store.mapper.QuestionMapper;

public class NoticeStoreLogic implements NoticeStore {

	private SqlSessionFactory factory;

	public NoticeStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public List<Post> selectAllNotice() {
		SqlSession session = factory.openSession();
		List<Post> list = new ArrayList<>();

		try {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			list = mapper.selectAllNotice();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Post selectNoticeById(String noticeId) {
		SqlSession session = factory.openSession();
		Post post;

		try {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			post = mapper.selectNoticeById(noticeId);
		} finally {
			session.close();
		}
		return post;
	}

	@Override
	public void updateNotice(Post post) {
		SqlSession session = factory.openSession();
		try {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			mapper.updateNotice(post);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void deleteNotice(String noticeId) {
		SqlSession session = factory.openSession();
		try {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			mapper.deleteNotice(noticeId);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void insertNotice(Post post) {
		SqlSession session = factory.openSession();
		try {
			NoticeMapper mapper = session.getMapper(NoticeMapper.class);
			mapper.insertNotice(post);
			session.commit();
		} finally {
			session.close();
		}
	}

}
