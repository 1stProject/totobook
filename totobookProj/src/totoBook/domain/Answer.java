package totoBook.domain;

/**
 * @author
 * @version 1.0
 */
public class Answer {
	private String content;
	private Post post;
	private String answerId;
	
	public String getContent() {
		return content;
	}
	public String getAnswerId() {
		return answerId;
	}
	public void setAnswerId(String answerId) {
		this.answerId = answerId;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Post getPost() {
		return post;
	}
	public void setPost(Post post) {
		this.post = post;
	}
	
	
}
