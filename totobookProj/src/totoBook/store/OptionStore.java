package totoBook.store;

import java.util.List;

import totoBook.domain.Option;

public interface OptionStore {

	void insertOption(Option option);
	void modifyOption(Option option);
	void removeOption(Option option);
	List<Option> findAll();
	
}
