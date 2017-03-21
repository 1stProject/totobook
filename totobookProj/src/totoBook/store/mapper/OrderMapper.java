package totoBook.store.mapper;

import java.sql.Date;
import java.util.List;

import totoBook.domain.Order;

/**
 * @author
 * @version 1.0
 */

public interface OrderMapper {
	void insertOrder(Order order);
	void updateOrder(Order order);
	List<Order> selectAllOrders();
	List<Order> selectOrdersByMemberId(String memberId);
	List<Order> selectOrdersByDates(Date StartDate, Date endDate);
	List<Order> selectOrdersByOrderId(String orderId);
}
