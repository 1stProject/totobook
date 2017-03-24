package totoBook.store;

import java.util.List;

import totoBook.domain.Member;
import totoBook.domain.Product;
import totoBook.domain.Review;

/**
 * @author
 * @version 1.0
 */
public interface ReviewStore {

	void insertComment(Review review);
	void updateComment(Review review);
	void deleteCommentByProduct(Product product);
	List<Review> selectCommentsByProduct(String productId);
	List<Review> selectCommentsByMember(String memberId);
	List<Review> selectCommentByOrder(String orderId);
	void deleteCommentByMember(String orderId);
	
}
