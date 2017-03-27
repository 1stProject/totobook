package totoBook.domain;

import java.util.List;

/**
 * @author
 * @version 1.0
 */
public class Print {
	private String printId;
	private List<Photo> photos;
	private Member member;
	private Product product;
	private String optionDesp;
	private int price;
	
	public String getPrintId() {
		return printId;
	}
	public void setPrintId(String printId) {
		this.printId = printId;
	}
	public List<Photo> getPhotos() {
		return photos;
	}
	public void setPhotos(List<Photo> photos) {
		this.photos = photos;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public String getOptionDesp() {
		return optionDesp;
	}
	public void setOptionDesp(String optionDesp) {
		this.optionDesp = optionDesp;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	
}
