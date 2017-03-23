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
	void deleteCommentByMember(Member member);
	void deleteCommentByProduct(Product product);
	List<Review> selectCommentsByProduct(Product product);
	List<Review> selectCommentsByMember(Member member);
	
}
