package totoBook.domain;

/**
 * @author
 * @version 1.0
 */
public class Option {

	private String optionId;
	private String[] optionName;
	private String[] optionDesp;
	private int[] optionPrice;
	private String productId;
	
	
	
	public String getOptionId() {
		return optionId;
	}
	public void setOptionId(String optionId) {
		this.optionId = optionId;
	}
	public String[] getOptionName() {
		return optionName;
	}
	public void setOptionName(String[] optionName) {
		this.optionName = optionName;
	}
	public String[] getOptionDesp() {
		return optionDesp;
	}
	public void setOptionDesp(String[] optionDesp) {
		this.optionDesp = optionDesp;
	}
	public int[] getOptionPrice() {
		return optionPrice;
	}
	public void setOptionPrice(int[] opprice) {
		this.optionPrice = opprice;
	}
	
	
	
}
