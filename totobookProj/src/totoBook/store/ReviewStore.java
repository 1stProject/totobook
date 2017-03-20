package totoBook.store;

import java.util.List;

import totoBook.domain.Member;
import totoBook.domain.Product;
import totoBook.domain.Review;

public interface ReviewStore {

	void insertComment(Review review);
	void updateComment(Review review);
	void deleteCommentByMember(Member member);
	void deleteCommentByProduct(Product product);
	List<Review> selectCommentsByProduct(Product product);
	List<Review> selectCommentsByMember(Product product);
	
}
