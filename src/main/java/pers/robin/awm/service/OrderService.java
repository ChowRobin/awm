package pers.robin.awm.service;

import pers.robin.awm.bean.OrderStatus;
import pers.robin.awm.model.Order;
import pers.robin.awm.viewmodel.OrderView;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> findByCondition(Map<String, Object> map, int pageId);

    List<Order> getNewOrders(int shopId);

    Order findById(Integer id);

    Integer create(Order order);

    Integer update(Order order);

    Integer delete(Integer id);

    Integer updateStatus(int id, OrderStatus status);

    Integer pay(int id);

    Integer accept(int id);

    Integer cancelByCustomer(int id);

    Integer complete(int id);

    OrderView modelToViewModel(Order order);
}
