package totoBook.store.logic;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import totoBook.domain.Post;
import totoBook.store.QuestionStore;

public class QuestionStoreLogic implements QuestionStore{

	@Override
	public void insertQuestion(Post post) {
		
		
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
