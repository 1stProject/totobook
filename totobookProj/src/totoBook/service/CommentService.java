package totoBook.service;

import java.util.List;

import totoBook.domain.Comment;
import totoBook.domain.Product;

public interface CommentService {

	public void registerComment(Comment comment);
	public void modifyComment(Comment comment);
	public void removeComment(Comment comment);
	public List<Comment> findCommentsByProduct(Product product);
	public List<Comment> findCommentsByMember(Product product);
	
	

	
}
