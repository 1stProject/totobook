package totoBook.store;

import java.util.List;

import totoBook.domain.Post;

/**
 * @author
 * @version 1.0
 */
public interface QuestionStore {
	void insertQuestion(Post post);
	List<Post>	selectAllQuestion();
	Post selectQuestionById(String questionId);
	void updateQuestion(Post post);
	void deleteQuestion(String questionId);
}
