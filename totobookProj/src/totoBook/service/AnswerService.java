package totoBook.service;

import totoBook.domain.Answer;

/**
 * @author
 * @version 1.0
 */
public interface AnswerService {
	void registerAnswer(Answer answer);
	Answer findAnswerById(String answerId);
	void modifyAnswer(Answer answer);
	void removeAnswer(String answerId);
}
