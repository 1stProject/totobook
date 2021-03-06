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
	String insertProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	Product selectProductById(String productId);
	List<Product> selectProductsByCategory(String category);
	
}
