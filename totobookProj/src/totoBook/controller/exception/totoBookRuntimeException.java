package totoBook.controller.exception;

public class totoBookRuntimeException extends RuntimeException{
	private static final long serialVersionUID = -6259362625181255085L;
	private String redirectURL;
	
	public totoBookRuntimeException(String message) {
		super(message);
	}
	
	public String getRedirectURL(){
		return redirectURL;
	}
	
	public void setRedirectURL(String redirectURL){
		this.redirectURL = redirectURL;
	}
}
