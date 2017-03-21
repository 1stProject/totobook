package totoBook.store.logic;

import java.sql.Date;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import totoBook.domain.Order;
import totoBook.store.OrderStore;
import totoBook.store.mapper.MemberMapper;
import totoBook.store.mapper.OrderMapper;

/**
 * @author
 * @version 1.0
 */
public class OrderStoreLogic implements OrderStore {
	private SqlSessionFactory factory;
	
	public OrderStoreLogic(){
		factory = SqlSessionFactoryProvider.getSqlSessionFactory();
	}
	@Override
	public void insertOrder(Order order) {
		SqlSession session = factory.openSession();
		try{
			OrderMapper mapper = session.getMapper(OrderMapper.class);
			mapper.insertOrder(order);
			session.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public void updateOrder(Order order) {
		SqlSession session = factory.openSession();
		try{
			OrderMapper mapper = session.getMapper(OrderMapper.class);
			mapper.updateOrder(order);
			session.commit();
		}finally{
			session.close();
		}
	}

	@Override
	public List<Order> selectAllOrders() {
		SqlSession session = factory.openSession();
		List<Order> orders = null;
		try{
			OrderMapper mapper = session.getMapper(OrderMapper.class);
			orders = mapper.selectAllOrders();
			session.commit();
		}finally{
			session.close();
		}
		return orders;
	}

	@Override
	public List<Order> selectOrdersByMemberId(String memberId) {
		SqlSession session = factory.openSession();
		List<Order> orders = null;
		try{
			OrderMapper mapper = session.getMapper(OrderMapper.class);
			orders = mapper.selectOrdersByMemberId(memberId);
			session.commit();
		}finally{
			session.close();
		}
		return orders;
	}

	@Override
	public List<Order> selectOrdersByDates(Date startDate, Date endDate) {
		SqlSession session = factory.openSession();
		List<Order> orders = null;
		try{
			OrderMapper mapper = session.getMapper(OrderMapper.class);
			orders = mapper.selectOrdersByDates(startDate, endDate);
			session.commit();
		}finally{
			session.close();
		}
		return orders;
	}

	@Override
	public List<Order> selectOrdersByOrderId(String orderId) {
		SqlSession session = factory.openSession();
		List<Order> orders = null;
		try{
			OrderMapper mapper = session.getMapper(OrderMapper.class);
			orders = mapper.selectOrdersByOrderId(orderId);
			session.commit();
		}finally{
			session.close();
		}
		return orders;
	}

}
