package totoBook.domain;

/**
 * @author
 * @version 1.0
 */
public class Photo {
	private String photoId;
	private String fileName;
	private String contentType;
	private int amount;
	private String printId;
	
	public String getPhotoId() {
		return photoId;
	}
	public void setPhotoId(String photoId) {
		this.photoId = photoId;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getContentType() {
		return contentType;
	}
	public void setContentType(String contentType) {
		this.contentType = contentType;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public String getPrintId() {
		return printId;
	}
	public void setPrintId(String printId) {
		this.printId = printId;
	}
	
	
}

