package pers.robin.awm.service.impl;

import org.springframework.stereotype.Service;
import pers.robin.awm.model.Order;
import pers.robin.awm.service.OrderService;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<Order> findByCondition(Map<String, Object> map) {
        return null;
    }

    @Override
    public List<Order> getNewOrders(int shopId) {
        return null;
    }

    @Override
    public Order findById(Order order) {
        return null;
    }

    @Override
    public Integer create(Order order) {
        return null;
    }

    @Override
    public Integer update(Order order) {
        return null;
    }

    @Override
    public Integer delete(Integer id) {
        return null;
    }

    @Override
    public Integer updateStatus(int id, Short status) {
        return null;
    }

    @Override
    public Integer pay(int id) {
        return null;
    }

    @Override
    public Integer cancelByCustomer(int id) {
        return null;
    }

    @Override
    public Integer complete(int id) {
        return null;
    }
}
