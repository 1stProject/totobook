package totoBook.service;

import java.util.List;

import totoBook.domain.Post;

public interface QuestionService {
	void registerQuestion(Post post);
	List<Post> findAllQuestion();
	Post findQuestionById(String questionId);
	void modifyQuestion(Post post);
	void removeQuestion(String questionId);
}
