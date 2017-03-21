package totoBook.domain;

/**
 * @author
 * @version 1.0
 */
public class Page {
	
	private String pageId;
	private Book book;
	private String imageAddress;
	
	public String getPageId() {
		return pageId;
	}
	public void setPageId(String pageId) {
		this.pageId = pageId;
	}
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public String getImageAddress() {
		return imageAddress;
	}
	public void setImageAddress(String imageAddress) {
		this.imageAddress = imageAddress;
	}


	
	
}