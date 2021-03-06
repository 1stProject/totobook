package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Post;
import totoBook.service.QuestionService;
import totoBook.store.QuestionStore;
import totoBook.store.logic.QuestionStoreLogic;

public class QuestionServiceLogic implements QuestionService{

	public QuestionServiceLogic() {
		
	}
	@Override
	public void registerQuestion(Post post) {
		QuestionStore store = new QuestionStoreLogic();
		store.insertQuestion(post);
		
	}

	@Override
	public List<Post> findAllQuestion() {
		QuestionStore store = new QuestionStoreLogic();
		List<Post> list = store.selectAllQuestion();
		return list;
	}

	@Override
	public Post findQuestionById(String questionId) {
		QuestionStore store = new QuestionStoreLogic();
		Post post = store.selectQuestionById(questionId);
		return post;
	}

	@Override
	public void modifyQuestion(Post post) {
		QuestionStore store = new QuestionStoreLogic();
		store.updateQuestion(post);
		
	}

	@Override
	public void removeQuestion(String questionId) {
		QuestionStore store = new QuestionStoreLogic();
		store.deleteQuestion(questionId);
	}

}
