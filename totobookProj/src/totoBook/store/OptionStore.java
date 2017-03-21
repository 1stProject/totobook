package totoBook.store;

import java.util.List;

import totoBook.domain.Option;

/**
 * @author
 * @version 1.0
 */
public interface OptionStore {

	void insertOption(Option option);
	void modifyOption(Option option);
	void deleteOption(Option option);
	List<Option> selectOptions(String product_id);

}
