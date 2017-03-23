package totoBook.domain;

public class Option {

	private String optionName;
	private String optionDesp;
	private int optionPrice;
	private Product product;
	
	
	
	
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getOptionName() {
		return optionName;
	}
	public void setOptionName(String optionName) {
		this.optionName = optionName;
	}
	public String getOptionDesp() {
		return optionDesp;
	}
	public void setOptionDesp(String optionDesp) {
		this.optionDesp = optionDesp;
	}
	public int getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(int opprice) {
		this.optionPrice = opprice;
	}
	
	
}
