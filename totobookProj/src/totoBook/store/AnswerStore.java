package totoBook.store;

import totoBook.domain.Answer;

public interface AnswerStore {
	void insertAnswer(Answer answer);
	Answer selectAnswerById(String postId);
	void updateAnswer(Answer answer);
	void deleteAnswer(String postId);
}
