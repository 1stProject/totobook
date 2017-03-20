package totoBook.domain;

import java.util.List;

/**
 * @author juhee Kim
 * @version 1.0
 */
public class Book {
	
	private String bookId;
	private String bookName;
	private List<Page> pages;
	private Member member;
	private Product product;
	
	public String getBookId() {
		return bookId;
	}
	public void setBookId(String bookId) {
		this.bookId = bookId;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public List<Page> getPages() {
		return pages;
	}
	public void setPages(List<Page> pages) {
		this.pages = pages;
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
	
	public int countPages(){
		return this.pages.size();
	}
	
	

}