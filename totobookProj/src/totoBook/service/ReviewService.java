package totoBook.service;

import java.util.List;

import totoBook.domain.Review;
import totoBook.domain.Member;
import totoBook.domain.Product;

public interface ReviewService {

	public void registerComment(Review review);
	public void modifyComment(Review review);
	public void deleteCommentByMember(Member member);
	public void deleteCommentByProduct(Product product);
	public List<Review> findCommentsByProduct(Product product);
	public List<Review> findCommentsByMember(Member member);
	
	

	
	
}
