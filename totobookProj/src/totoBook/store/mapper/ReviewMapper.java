package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Review;
import totoBook.domain.Member;
import totoBook.domain.Product;

/**
 * @author
 * @version 1.0
 */

public interface ReviewMapper {

	void insertComment(Review review);
	void updateComment(Review review);
	void deleteCommentByMember(String orderId);
	void deleteCommentByProduct(Product product);
	List<Review> selectCommentsByProduct(String productId);
	List<Review> selectCommentsByMember(String memberId);
	List<Review> selectCommentByOrder(String orderId);
	
}
