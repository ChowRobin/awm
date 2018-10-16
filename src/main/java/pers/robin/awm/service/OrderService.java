package pers.robin.awm.service;

import pers.robin.awm.model.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> findByCondition(Map<String, Object> map);

    List<Order> getNewOrders(int shopId);

    Order findById(Order order);

    Integer create(Order order);

    Integer update(Order order);

    Integer delete(Integer id);

    Integer updateStatus(int id, Short status);

    Integer pay(int id);

    Integer cancelByCustomer(int id);

    Integer complete(int id);
}
