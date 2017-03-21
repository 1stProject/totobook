package totoBook.store;

import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;

/**
 * @author
 * @version 1.0
 */

public interface ProductStore {

	List<Product> selectProductsByName(String name);
	List<Product> selectAllProducts();
	void insertProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	Product selectProductById(String productId);
	List<Product> selectProductsByCategory(String category);
	void insertOption(Option option);
	void modifyOption(Option option);
	void deleteOption(Option option);
	List<Option> selectOptions(String product_id);
	
}
