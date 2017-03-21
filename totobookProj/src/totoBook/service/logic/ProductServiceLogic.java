package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;
import totoBook.service.ProductService;
import totoBook.store.OptionStore;
import totoBook.store.ProductStore;
import totoBook.store.logic.OptionStoreLogic;
import totoBook.store.logic.ProductStoreLogic;

public class ProductServiceLogic implements ProductService {

	
	private ProductStore productstore;
	private OptionStore optionstore;
	
	
	public ProductServiceLogic() {

		productstore = new ProductStoreLogic();
		optionstore = new OptionStoreLogic();
	
	}

	@Override
	public List<Product> findAllProducts() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Option findOption(String product_id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Product findProductById(String productId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findProductsByCategory(String category) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Product> findProductsByName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void modifyOption(Option option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void modifyProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerOption(Option option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void registerProduct(Product product) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeOption(Option option) {
		// TODO Auto-generated method stub

	}

	@Override
	public void removeProduct(String productId) {
		// TODO Auto-generated method stub

	}

}
