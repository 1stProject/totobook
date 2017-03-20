package totoBook.service;

import java.sql.Date;
import java.util.List;

import totoBook.domain.Order;

public interface OrderService {
	void registerOrder(Order order);
	List<Order> findAllOrders();
	List<Order> findOrdersByMemberId(String memberId);
	List<Order> findOrdersByOrderId(String orderId);
	List<Order> findOrdersByDates(Date startDate, Date endDate);
	void modifyOrder(Order order);
}
