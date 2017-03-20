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
	public void deleteProduct(Product product) {
		SqlSession session = factory.openSession();
		try {

			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.deleteProduct(product);
			session.commit();
		} finally {
			session.close();
		}	
		
		
	}
	
	@Override
	public Option findOption(String product_id) {
		SqlSession session = factory.openSession();
		Option option = new Option();
		
		try {

			ProductMapper mapper = session.getMapper(ProductMapper.class);
			option = mapper.findOption(product_id);
			session.commit();
		} finally {
			session.close();
		}	
		return option;
	}

	@Override
	public void insertOption(Option option) {
		SqlSession session = factory.openSession();

		
		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.registerOption(option);
			session.commit();
		}finally {
			session.close();
		}
	}

	@Override
	public void insertProduct(Product product) {
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.registerProduct(product);
			session.commit();
		}finally {
			session.close();
		}

	}

	@Override
	public void modifyOption(Option option) {
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.modifyOption(option);
			session.commit();
		}finally {
			session.close();
		}
	
	}

	@Override
	public void removeOption(Option option) {
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.removeOption(option);;
			session.commit();
		}finally {
			session.close();
		}
	
		
	}

	@Override
	public List<Product> selectAllProducts() {
		List<Product> list = new ArrayList<>();
		SqlSession session = factory.openSession();
		

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			list = mapper.findAllProducts();
			session.commit();
		}finally {
			session.close();
		}
	
		
		return list;
	}

	@Override
	public Product selectProductById(Product product) {
		SqlSession session = factory.openSession();
		

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			product = mapper.findProductById(product);
			session.commit();
		}finally {
			session.close();
		}
		
		return product;
	}

	@Override
	public List<Product> selectProductsByCategory(String category) {
		SqlSession session = factory.openSession();
		List<Product> list = new ArrayList<>();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			list = mapper.findProductsByCategory(category);
			session.commit();
		}finally {
			session.close();
		}
		
		return list;
		
	}

	@Override
	public List<Product> selectProductsByName(String name) {
		SqlSession session = factory.openSession();
		List<Product> list = new ArrayList<>();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			list = mapper.findProductsByName(name);
			session.commit();
		}finally {
			session.close();
		}
		
		return list;
	}

	@Override
	public void updateProduct(Product product) {
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.modifyProduct(product);
			session.commit();
		}finally {
			session.close();
		}

	}

}
