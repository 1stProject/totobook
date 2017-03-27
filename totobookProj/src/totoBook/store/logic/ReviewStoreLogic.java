package totoBook.store.logic;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Member;
import totoBook.domain.Product;
import totoBook.domain.Review;
import totoBook.store.ReviewStore;
import totoBook.store.mapper.ReviewMapper;

public class ReviewStoreLogic implements ReviewStore {

	private SqlSessionFactory factory;

	public ReviewStoreLogic() {
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}

	
	
	
	@Override
	public void deleteCommentByMember(String orderId) {
		SqlSession session = factory.openSession();
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			mapper.deleteCommentByMember(orderId);
			session.commit();

		} finally {
			session.close();
		}

	}

	@Override
	public void deleteCommentByProduct(String productId) {
		SqlSession session = factory.openSession();
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			mapper.deleteCommentByProduct(productId);
			session.commit();

		} finally {
			session.close();
		}

	}

	@Override
	public void insertComment(Review review) {
		SqlSession session = factory.openSession();
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			mapper.insertComment(review);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public void updateComment(Review review) {
		SqlSession session = factory.openSession();
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			mapper.updateComment(review);
			session.commit();
		} finally {
			session.close();
		}

	}

	@Override
	public List<Review> selectCommentsByMember(String memberId) {
		List<Review> list = new ArrayList<>();
		SqlSession session = factory.openSession();
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.selectCommentsByMember(memberId);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Review> selectCommentsByProduct(String productId) {
		List<Review> list = new ArrayList<>();
		System.out.println(productId);
		SqlSession session = factory.openSession();
		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.selectCommentsByProduct(productId);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Review> selectCommentByOrder(String orderId) {
		SqlSession session = factory.openSession();

		List<Review> list = new ArrayList<>();

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.selectCommentByOrder(orderId);
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

	@Override
	public List<Review> selectAllComents() {
		SqlSession session = factory.openSession();

		List<Review> list = new ArrayList<>();

		try {
			ReviewMapper mapper = session.getMapper(ReviewMapper.class);
			list = mapper.selectAllComents();
			session.commit();
		} finally {
			session.close();
		}
		return list;
	}

}
