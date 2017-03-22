package totoBook.service.logic;

import java.util.ArrayList;
import java.util.List;

import totoBook.domain.Option;
import totoBook.domain.Product;
import totoBook.service.ProductService;
import totoBook.store.OptionStore;
import totoBook.store.ProductStore;
import totoBook.store.ReviewStore;
import totoBook.store.logic.OptionStoreLogic;
import totoBook.store.logic.ProductStoreLogic;
import totoBook.store.logic.ReviewStoreLogic;

public class ProductServiceLogic implements ProductService {

	private ProductStore productStore;
	private OptionStore optionStore;
	private ReviewStore reviewStore;

	public ProductServiceLogic() {

		productStore = new ProductStoreLogic();
		optionStore = new OptionStoreLogic();
		reviewStore = new ReviewStoreLogic();
	}

	@Override
	public List<Product> findAllProducts() {
		List<Product> list = new ArrayList<>();
		return list = productStore.selectAllProducts();
		// 관리자 모든 상품보기
	}

	@Override
	public List<Option> findOption(String productId) {
		List<Option> list = new ArrayList<>();
		return list = optionStore.selectOptions(productId);
		// 상품의 옵션들 찾기
	}

	@Override
	public Product findProductById(String productId) {
		Product product = productStore.selectProductById(productId);
		product.setOptions(optionStore.selectOptions(productId));
		return product;
		// 상품상세보기 옵션들어가야함
	}

	@Override
	public List<Product> findProductsByCategory(String category) {
		List<Product> list = new ArrayList<>();
		return list = productStore.selectProductsByCategory(category);
		// 카페고리별로 상품보기
	}

	@Override
	public List<Product> findProductsByName(String name) {
		List<Product> list = new ArrayList<>();
		return list = productStore.selectProductsByName(name);
		// 관리자 상품검색

	}

	@Override
	public void modifyOption(Option option) {
		optionStore.deleteOption(option.getProductId());
		optionStore.insertOption(option);
		// 관리자 옵션 삭제 후 옵션 다시 등록

	}

	@Override
	public void modifyProduct(Product product) {
		productStore.updateProduct(product);
		// 관리자 상품수정
	}

	@Override
	public void registerOption(Option option) {
		optionStore.insertOption(option);
	}

	@Override
	public void registerProduct(Product product) {
		productStore.updateProduct(product);
	}

	@Override
	public void removeOption(String productId) {
		optionStore.deleteOption(productId);
	}

	@Override
	public void removeProduct(Product product) {
		optionStore.deleteOption(product.getProductId());
		reviewStore.deleteCommentByProduct(product);
		productStore.deleteProduct(product);
		// 상품삭제시 옵션,상품평도 같이 삭제
	}

}
