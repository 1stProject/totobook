package totoBook.store;

import java.sql.Date;
import java.util.List;

import totoBook.domain.Order;

/**
 * @author
 * @version 1.0
 */
public interface OrderStore {
	void insertOrder(Order order);
	void updateOrder(Order order);
	List<Order> selectAllOrders();
	List<Order> selectOrdersByMemberId(String memberId);
	List<Order> selectOrdersByDates(Date startDate, Date endDate);
	List<Order> selectOrdersByOrderId(String orderId);
}
