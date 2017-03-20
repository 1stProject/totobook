package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Book;
import totoBook.domain.Post;

public interface QuestionMapper {

	void insertQuestion(Post post);
	List<Post>	selectAllQuestion();
	Post selectQuestionById(String questionId);
	void updateQuestion(Post post);
	void deleteQuestion(String questionId);
}
