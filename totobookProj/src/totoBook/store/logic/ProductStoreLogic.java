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
	public String insertProduct(Product product) {
		SqlSession session = factory.openSession();
		String productId;
		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.insertProduct(product);
			 productId = product.getProductId();
			session.commit();
		} finally {
			session.close();
		}

		return productId;
		
	}

	@Override
	public List<Product> selectAllProducts() {
		List<Product> list = new ArrayList<>();
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			list = mapper.selectAllProducts();
			session.commit();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public Product selectProductById(String productid) {
		SqlSession session = factory.openSession();
		Product product = new Product();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			product = mapper.selectProductById(productid);
			session.commit();
		} finally {
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
			list = mapper.selectProductsByCategory(category);
			session.commit();
		} finally {
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
			list = mapper.selectProductsByName(name);
			session.commit();
		} finally {
			session.close();
		}

		return list;
	}

	@Override
	public void updateProduct(Product product) {
		SqlSession session = factory.openSession();

		try {
			ProductMapper mapper = session.getMapper(ProductMapper.class);
			mapper.updateProduct(product);
			session.commit();
		} finally {
			session.close();
		}

	}

}
