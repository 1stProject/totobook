package totoBook.store;

import java.util.List;

import totoBook.domain.Option;

/**
 * @author
 * @version 1.0
 */
public interface OptionStore {

	void insertOption(Option option);
	void updateOption(Option option);
	void deleteOption(String productId);
	List<Option> selectOptions(String productId);

}
