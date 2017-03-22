package totoBook.domain;

/**
 * @author juhee Kim
 * @version 1.0
 */
public class Post {
	private String postId;
	private Member member;
	private String title;
	private String content;
	private String imageAddressPath;
	private String image_ext;
	
	public String getPostId() {
		return postId;
	}
	public void setPostId(String postId) {
		this.postId = postId;
	}
	public Member getMember() {
		return member;
	}
	public void setMember(Member member) {
		this.member = member;
	}
	
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getImageAddressPath() {
		return imageAddressPath;
	}
	public void setImageAddressPath(String imageAddressPath) {
		this.imageAddressPath = imageAddressPath;
	}
	public String getImage_ext() {
		return image_ext;
	}
	public void setImage_ext(String image_ext) {
		this.image_ext = image_ext;
	}

}
