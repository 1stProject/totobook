package totoBook.store;

import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;

public interface ProductStore {

	public List<Product> findProductsByName(String name);
	public List<Product> findAllProducts();
	public void registerProduct(Product product);
	public void modifyProduct(Product product);
	public Product findProductById(String productId);
	public void removeProduct(String productId);
	public List<Product> findProductsByCategory(String category);
	public void registerOption(Option option);
	
	
}
