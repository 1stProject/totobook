package totoBook.domain;

import java.util.List;

/**
 * @author
 * @version 1.0
 */
public class Review {

	private Product product;
	private Member member;
	private String comment;
	private String imageAddress;
	private Order order;
	private Photo photo;


	
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}
	public Order getOrder() {
		return order;
	}
	public void setOrder(Order order) {
		this.order = order;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public String getComment() {
		return comment;
	}
	
	
	public void setComment(String comment) {
		this.comment = comment;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	
	
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}
	
	
	
	
}
