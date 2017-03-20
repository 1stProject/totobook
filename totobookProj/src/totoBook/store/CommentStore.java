package totoBook.store;

import java.util.List;

import totoBook.domain.Comment;
import totoBook.domain.Product;

public interface CommentStore {

	void insertComment(Comment comment);
	void updateComment(Comment comment);
	void deleteComment(Comment comment);
	List<Comment> selectCommentsByProduct(Product product);
	List<Comment> selectCommentsByMember(Product product);
	
}
