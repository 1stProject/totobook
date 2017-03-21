package totoBook.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Option;
import totoBook.domain.Product;
import totoBook.store.ProductStore;
import totoBook.store.mapper.ProductMapper;

/**
 * @author
 * @version 1.0
 */
public class ProductStoreLogic implements ProductStore {

	private SqlSessionFactory factory;

	public ProductStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}


@Override
public void deleteOption(Option option) {
	// TODO Auto-generated method stub
	
}

@Override
public void deleteProduct(Product product) {
	// TODO Auto-generated method stub
	
}

@Override
public void insertOption(Option option) {
	// TODO Auto-generated method stub
	
}

@Override
public void insertProduct(Product product) {
	// TODO Auto-generated method stub
	
}

@Override
public void modifyOption(Option option) {
	// TODO Auto-generated method stub
	
}

@Override
public List<Product> selectAllProducts() {
	// TODO Auto-generated method stub
	return null;
}
@Override
public List<Option> selectOptions(String product_id) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public Product selectProductById(String productId) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Product> selectProductsByCategory(String category) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public List<Product> selectProductsByName(String name) {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void updateProduct(Product product) {
	// TODO Auto-generated method stub
	
}

	
	

}
