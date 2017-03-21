package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;

/**
 * @author
 * @version 1.0
 */

public interface ProductMapper {

	List<Product> findProductsByName(String name);
	List<Product> findAllProducts();
	void registerProduct(Product product);
	void modifyProduct(Product product);
	Product findProductById(Product product);
	List<Product> findProductsByCategory(String category);
	void registerOption(Option option);
	void modifyOption(Option option);
	void removeOption(Option option);
	Option findOption(String product_id);
	void deleteProduct(Product product);

	
}
