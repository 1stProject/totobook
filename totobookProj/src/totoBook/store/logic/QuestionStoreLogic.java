package totoBook.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.catalina.tribes.group.AbsoluteOrder.AbsoluteComparator;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Post;
import totoBook.store.QuestionStore;
import totoBook.store.mapper.MemberMapper;
import totoBook.store.mapper.QuestionMapper;

public class QuestionStoreLogic implements QuestionStore {

	private SqlSessionFactory factory;

	public QuestionStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public void insertQuestion(Post post) {
		SqlSession session = factory.openSession();

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			mapper.insertQuestion(post);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Post> selectAllQuestion() {
		SqlSession session = factory.openSession();
		List<Post> list = new ArrayList<>();

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			list = mapper.selectAllQuestion();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Post selectQuestionById(String questionId) {
		SqlSession session = factory.openSession();
		Post post;

		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			post = mapper.selectQuestionById(questionId);
		} finally {
			session.close();
		}
		return post;
	}

	@Override
	public void updateQuestion(Post post) {
		SqlSession session = factory.openSession();
		try{
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			mapper.updateQuestion(post);
			session.commit();
		}finally {
			session.close();
		}

	}

	@Override
	public void deleteQuestion(String questionId) {
		SqlSession session = factory.openSession();
		try {
			QuestionMapper mapper = session.getMapper(QuestionMapper.class);
			mapper.deleteQuestion(questionId);
			session.commit();
		} finally {
			session.close();
		}

	}

}
