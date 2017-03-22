package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Option;

public interface OptionMapper {

	void insertOption(Option option);
	void updateOption(Option option);
	void deleteOption(String productId);
	List<Option> selectOptions(String productId);
}
