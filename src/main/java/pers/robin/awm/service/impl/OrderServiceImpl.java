package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.bean.OrderStatus;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.OrderMapper;
import pers.robin.awm.model.Order;
import pers.robin.awm.service.OrderService;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> findByCondition(Map<String, Object> map, int pageId) {
        PageHelper.startPage(pageId, PageConfig.size);
        return orderMapper.selectByCondition(map);
    }

    @Override
    public List<Order> getNewOrders(int shopId) {
        return orderMapper.selectNewOrders(shopId);
    }

    @Override
    public Order findById(Integer id) {
        return orderMapper.selectByPrimaryKey(id);
    }

    void check(Order order) {

    }

    @Override
    public Integer create(Order order) {
        check(order);
        orderMapper.insertSelective(order);
        return order.getId();
    }

    @Override
    public Integer update(Order order) {
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Integer delete(Integer id) {
        return orderMapper.deleteByPrimaryKey(id);
    }

    @Override
    public Integer updateStatus(int id, OrderStatus status) {
        Order order = new Order();
        order.setId(id);
        order.setStatus((short) status.getIndex());
        return orderMapper.updateByPrimaryKeySelective(order);
    }

    @Override
    public Integer pay(int id) {
        return updateStatus(id, OrderStatus.PAID);
    }

    @Override
    public Integer cancelByCustomer(int id) {
        return updateStatus(id, OrderStatus.CANCELED_BY_CUSTOMER);
    }

    @Override
    public Integer complete(int id) {
        return updateStatus(id, OrderStatus.COMPLETED);
    }
}
