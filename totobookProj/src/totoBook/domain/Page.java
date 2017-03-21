package totoBook.domain;

/**
 * @author
 * @version 1.0
 */
public class Page {
	
	private String pageId;
	private Book book;
	private Photo photo;
	
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
	public Photo getPhoto() {
		return photo;
	}
	public void setPhoto(Photo photo) {
		this.photo = photo;
	}

	
	
}