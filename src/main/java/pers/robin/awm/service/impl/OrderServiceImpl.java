package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.bean.OrderStatus;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.OrderMapper;
import pers.robin.awm.model.Order;
import pers.robin.awm.model.OrderDetail;
import pers.robin.awm.service.OrderDetailService;
import pers.robin.awm.service.OrderService;
import pers.robin.awm.viewmodel.OrderView;

import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Autowired
    private OrderDetailService orderDetailService;

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
        if (order.getPrice() == null) order.setPrice(0);
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
    public Integer accept(int id) {
        return updateStatus(id, OrderStatus.ACCEPT);
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

    @Override
    public OrderView modelToViewModel(Order order) {
        OrderView orderView = new OrderView(
                order.getId(),
                order.getCode(),
                order.getPrice(),
                order.getUserId(),
                order.getIp(),
                order.getAddress(),
                order.getProvider(),
                order.getStatus(),
                order.getDeliveryDate(),
                order.getDeliveryTime(),
                order.getRemark(),
                order.getCreatedAt(),
                order.getUpdatedAt()
        );
        orderView.setOrderDetailViews(orderDetailService.findByOrderId(order.getId()));
        return orderView;
    }
}
