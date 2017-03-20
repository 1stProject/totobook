package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;

public interface ProductMapper {

	List<Product> selectProductsByName(String name);
	List<Product> selectAllProducts();
	void insertProduct(Product product);
	void updateProduct(Product product);
	void deleteProduct(Product product);
	Product selectProductById(Product product);
	List<Product> selectProductsByCategory(String category);
	void insertOption(Option option);
	void modifyOption(Option option);
	void removeOption(Option option);
	
	
}
