package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Option;

public interface OptionMapper {

	void insertOption(Option option);
	void modifyOption(Option option);
	void deleteOption(Option option);
	List<Option> selectOptions(String productid);
}
