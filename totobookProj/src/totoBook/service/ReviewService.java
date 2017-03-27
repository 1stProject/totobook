package totoBook.service;

import java.util.List;

import totoBook.domain.Review;
import totoBook.domain.Member;
import totoBook.domain.Product;

/**
 * @author
 * @version 1.0
 */
public interface ReviewService {

	public void registerComment(Review review);
	public void modifyComment(Review review);
	public void deleteCommentByProduct(String productId);
	public List<Review> findCommentsByProduct(String productId);
	public List<Review> findCommentsByMember(String memberId);
	public List<Review> findCommentByOrder(String orderId);
	public void deleteCommentByMember(String orderId); 
	public List<Review> findAllComents();
	
	
}
