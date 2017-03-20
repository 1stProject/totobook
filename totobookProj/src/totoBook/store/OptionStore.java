package totoBook.store;

import totoBook.domain.Option;

/**
 * @author
 * @version 1.0
 */
public interface OptionStore {

	void insertOption(Option option);
	void modifyOption(Option option);
	void removeOption(Option option);
	Option selectOption(String product_id);

}
