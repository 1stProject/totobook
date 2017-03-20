package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;

public interface ProductMapper {

	List<Product> findProductsByName(String name);
	List<Product> findAllProducts();
	void registerProduct(Product product);
	void modifyProduct(Product product);
	Product findProductById(String productId);
	void removeProduct(String productId);
	List<Product> findProductsByCategory(String category);
	void registerOption(Option option);
	void modifyOption(Option option);
	void removeOption(Option option);
	List<Option> findAllOptions();
	
	
}
