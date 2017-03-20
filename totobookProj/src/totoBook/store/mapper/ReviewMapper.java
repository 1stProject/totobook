package totoBook.store.mapper;

import java.util.List;

import totoBook.domain.Review;
import totoBook.domain.Product;

public interface ReviewMapper {

	void insertComment(Review review);
	void updateComment(Review review);
	void deleteComment(Review review);
	List<Review> selectCommentsByProduct(Product product);
	List<Review> selectCommentsByMember(Product product);
	
}