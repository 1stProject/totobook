package totoBook.service.logic;

import java.sql.Date;
import java.util.List;

import totoBook.domain.Order;
import totoBook.service.OrderService;
import totoBook.store.OrderStore;
import totoBook.store.logic.OrderStoreLogic;

/**
 * @author
 * @version 1.0
 */
public class OrderServiceLogic implements OrderService {
	private OrderStore orderStore;
	public OrderServiceLogic() {
		orderStore = new OrderStoreLogic();
	}
	@Override
	public void registerOrder(Order order) {
		orderStore.insertOrder(order);
	}

	@Override
	public List<Order> findAllOrders() {
		return orderStore.selectAllOrders();
	}

	@Override
	public List<Order> findOrdersByMemberId(String memberId) {
		return orderStore.selectOrdersByMemberId(memberId);
	}

	@Override
	public List<Order> findOrdersByOrderId(String orderId) {
		return orderStore.selectOrdersByOrderId(orderId);
	}

	@Override
	public List<Order> findOrdersByDates(Date startDate, Date endDate) {
		return orderStore.selectOrdersByDates(startDate, endDate);
	}

	@Override
	public void modifyOrder(Order order) {
		orderStore.updateOrder(order);
	}

}
