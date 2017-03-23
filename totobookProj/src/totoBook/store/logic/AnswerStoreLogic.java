package totoBook.store.logic;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Answer;
import totoBook.store.AnswerStore;
import totoBook.store.mapper.AnswerMapper;

public class AnswerStoreLogic implements AnswerStore {
	private SqlSessionFactory factory;

	public AnswerStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	@Override
	public void insertAnswer(Answer answer) {
		SqlSession session = factory.openSession();
		
		try{
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			mapper.insertAnswer(answer);
			session.commit();
		}finally {
			session.close();
		}

	}

	@Override
	public Answer selectAnswerById(String postId) {
		SqlSession session = factory.openSession();
		Answer answer;
		try {
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			answer = mapper.selectAnswerById(postId);
		} finally {
			session.close();
		}
		return answer;
	}

	@Override
	public void updateAnswer(Answer answer) {
		SqlSession session = factory.openSession();
		try{
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			mapper.updateAnswer(answer);
			session.commit();
		}finally {
			session.close();
		}

	}

	@Override
	public void deleteAnswer(String postId) {
		SqlSession session = factory.openSession();
		try {
			AnswerMapper mapper = session.getMapper(AnswerMapper.class);
			mapper.deleteAnswer(postId);
			session.commit();
		} finally {
			session.close();
		}
	}

}
