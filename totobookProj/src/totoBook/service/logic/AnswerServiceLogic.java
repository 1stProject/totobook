package totoBook.service.logic;

import totoBook.domain.Answer;
import totoBook.service.AnswerService;
import totoBook.store.AnswerStore;
import totoBook.store.logic.AnswerStoreLogic;

public class AnswerServiceLogic implements AnswerService{

	@Override
	public void registerAnswer(Answer answer) {
		AnswerStore store = new AnswerStoreLogic();
		store.insertAnswer(answer);
		
	}

	@Override
	public Answer findAnswerById(String answerId) {
		AnswerStore store = new AnswerStoreLogic();
		Answer answer = store.selectAnswerById(answerId);
		return answer;
	}

	@Override
	public void modifyAnswer(Answer answer) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void removeAnswer(String answerId) {
		AnswerStore store = new AnswerStoreLogic();
		store.deleteAnswer(answerId);
		
	}

}
