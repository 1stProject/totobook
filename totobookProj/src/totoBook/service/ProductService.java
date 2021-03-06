package totoBook.service;

import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;

/**
 * @author
 * @version 1.0
 */
public interface ProductService {

	public List<Product> findProductsByName(String name);
	public List<Product> findAllProducts();
	public void registerProduct(Product product);
	public void modifyProduct(Product product);
	public Product findProductById(String productId);
	public void removeProduct(Product product);
	public List<Product> findProductsByCategory(String category);
	public void registerOption(Option option);
	public void modifyOption(Option option);
	public void removeOption(String productId);
	public List<Option> findOption(String productId);

	
}
