package totoBook.domain;

import java.util.List;

/**
 * @author
 * @version 1.0
 */
public class Product {


	private String productId;
	private String name;
	private String imageAddress;
	private int productprice;
	private String category;
	private String descript;
	private List<Option> options;
	private int quantity;
	
	public String getProductId() {
		return productId;
	}
	public void setProductId(String productId) {
		this.productId = productId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getProductprice() {
		return productprice;
	}
	public void setProductprice(int productprice) {
		this.productprice = productprice;
	}
	public String getCategory() {
		return category;
	}
	public void setCategory(String category) {
		this.category = category;
	}
	public String getDescript() {
		return descript;
	}
	public void setDescript(String descript) {
		this.descript = descript;
	}
	public List<Option> getOptions() {
		return options;
	}
	public void setOptions(List<Option> options) {
		this.options = options;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}

	@Override
	public String toString() {
		return "Product [productId=" + productId + ", name=" + name + ", imageAddress=" + imageAddress
				+ ", productprice=" + productprice + ", category=" + category + ", descript=" + descript + ", options="
				+ options + ", quantity=" + quantity + "]";
	}	
	
}
