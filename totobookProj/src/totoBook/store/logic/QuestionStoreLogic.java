package totoBook.store.logic;

import java.util.List;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Post selectQuestionById(String questionId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void updateQuestion(Post post) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteQuestion(String questionId) {
		// TODO Auto-generated method stub

	}

}
