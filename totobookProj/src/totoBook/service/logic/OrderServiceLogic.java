package totoBook.service.logic;

import java.sql.Date;
import java.util.List;

import totoBook.domain.Order;
import totoBook.service.OrderService;

public class OrderServiceLogic implements OrderService {

	@Override
	public void registerOrder(Order order) {
		
	}

	@Override
	public List<Order> findAllOrders() {
		return null;
	}

	@Override
	public List<Order> findOrdersByMemberId(String memberId) {
		return null;
	}

	@Override
	public List<Order> findOrdersByOrderId(String orderId) {
		return null;
	}

	@Override
	public List<Order> findOrdersByDates(Date startDate, Date endDate) {
		return null;
	}

	@Override
	public void modifyOrder(Order order) {
	}

}
