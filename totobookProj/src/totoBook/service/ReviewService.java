package totoBook.service;

import java.util.List;

import totoBook.domain.Review;
import totoBook.domain.Product;

public interface ReviewService {

	public void registerComment(Review review);
	public void modifyComment(Review review);
	public void removeComment(Review review);
	public List<Review> findCommentsByProduct(Product product);
	public List<Review> findCommentsByMember(Product product);
	
	

	
}
