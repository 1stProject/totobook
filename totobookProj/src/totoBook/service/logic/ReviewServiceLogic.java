package totoBook.service.logic;

import java.util.List;

import totoBook.domain.Member;
import totoBook.domain.Product;
import totoBook.domain.Review;
import totoBook.service.ReviewService;
import totoBook.store.ReviewStore;
import totoBook.store.logic.ReviewStoreLogic;

public class ReviewServiceLogic implements ReviewService {

	private ReviewStore reviewStore;

	public ReviewServiceLogic() {
		reviewStore = new ReviewStoreLogic();
	}

	@Override
	public void deleteCommentByMember(Member member) {
		reviewStore.deleteCommentByMember(member);

	}

	@Override
	public void deleteCommentByProduct(Product product) {
		reviewStore.deleteCommentByProduct(product);

	}

	@Override
	public List<Review> findCommentsByMember(String memberId) {
//		String memberid = member.getMemberId();
		List<Review> list = reviewStore.selectCommentsByMember(memberId);
		return list;
	}

	@Override
	public List<Review> findCommentsByProduct(String productId) {
		List<Review> list = reviewStore.selectCommentsByProduct(productId);
		return list;
	}

	@Override
	public void modifyComment(Review review) {
		reviewStore.updateComment(review);
	}

	@Override
	public void registerComment(Review review) {
		reviewStore.insertComment(review);

	}

}
