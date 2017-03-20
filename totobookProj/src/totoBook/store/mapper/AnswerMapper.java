package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Answer;
import totoBook.domain.Book;
import totoBook.domain.Post;

public interface AnswerMapper {
	
	void insertAnswer(Answer answer);
	Answer selectAnswerById(String postId);
	void updateAnswer(Answer answer);
	void deleteAnswer(String postId);
}
