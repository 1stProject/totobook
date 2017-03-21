package totoBook.domain;

import java.sql.Date;
import java.util.List;

/**
 * @author
 * @version 1.0
 */
public class Order {
	private String orderId;
	private Date ordDate;
	private String payment;
	private int ordPrice;
	private Member member;
	private String ordWay;
	private List<Product> product;
	
	public String getOrderId() {
		return orderId;
	}
	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}
	public Date getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(Date ordDate) {
		this.ordDate = ordDate;
	}
	public String getOrdWay() {
		return ordWay;
	}
	public void setOrdWay(String ordWay) {
		this.ordWay = ordWay;
	}
	
	public String getPayment() {
		return payment;
	}
	public void setPayment(String payment) {
		this.payment = payment;
	}
	public int getOrdPrice() {
		return ordPrice;
	}
	public void setOrdPrice(int ordPrice) {
		this.ordPrice = ordPrice;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	public List<Product> getProduct() {
		return product;
	}
	public void setProduct(List<Product> product) {
		this.product = product;
	}
}
