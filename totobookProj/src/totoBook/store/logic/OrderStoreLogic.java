package totoBook.store.logic;

import java.sql.Date;
import java.util.List;

import totoBook.domain.Order;
import totoBook.store.OrderStore;

public class OrderStoreLogic implements OrderStore {

	@Override
	public void insertOrder(Order order) {
	}

	@Override
	public void updateOrder(Order order) {
	}

	@Override
	public List<Order> selectAllOrders() {
		return null;
	}

	@Override
	public List<Order> selectOrdersByMemberId(String memberId) {
		return null;
	}

	@Override
	public List<Order> selectOrdersByDates(Date StartDate, Date endDate) {
		return null;
	}

	@Override
	public List<Order> selectOrdersByOrderId(String orderId) {
		return null;
	}

}
