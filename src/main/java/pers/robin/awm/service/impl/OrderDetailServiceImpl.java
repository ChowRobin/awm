package pers.robin.awm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pers.robin.awm.dao.OrderDetailMapper;
import pers.robin.awm.exception.CheckException;
import pers.robin.awm.model.Order;
import pers.robin.awm.model.OrderDetail;
import pers.robin.awm.service.DishesService;
import pers.robin.awm.service.OrderDetailService;
import pers.robin.awm.service.OrderService;
import pers.robin.awm.viewmodel.OrderDetailView;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Autowired
    private OrderService orderService;

    @Autowired
    private DishesService dishesService;

    private int reCountOrderPrice(int orderId) {
        List<OrderDetail> orderDetails = orderDetailMapper.selectByOrderId(orderId);
        Order order = new Order();
        order.setId(orderId);
        order.setPrice(orderDetails.stream()
                            .mapToInt(o -> o.getPrice())
                            .sum());
        return orderService.update(order);
    }

    private int updateOrderPrice(int orderId, int p) {
        Order order = orderService.findById(orderId);
        order.setPrice(order.getPrice() + p);
        return orderService.update(order);
    }

    @Override
    public List<OrderDetailView> findByOrderId(int orderId) {
        List<OrderDetail> list = orderDetailMapper.selectByOrderId(orderId);
        List<OrderDetailView> detailViews = list.stream()
                                                .map(this::modelToViewModel)
                                                .collect(Collectors.toList());
        return detailViews;
    }

    void check(OrderDetail orderDetail) {
        int dishesFromShopId = dishesService.findById(orderDetail.getItemId()).getProvider();
        int orderFromShopId = orderService.findById(orderDetail.getOrderId()).getProvider();
        if (dishesFromShopId != orderFromShopId) {
            throw new CheckException("The dishes-shop is not the same as the order-shop.");
        }
    }

    @Override
    @Transactional
    public int create(OrderDetail orderDetail) {
        check(orderDetail);
        updateOrderPrice(orderDetail.getOrderId(), orderDetail.getPrice());
        return orderDetailMapper.insertSelective(orderDetail);
    }

    @Override
    @Transactional
    public int update(OrderDetail orderDetail) {
        int ret = orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
        reCountOrderPrice(orderDetail.getOrderId());
        return ret;
    }

    @Override
    @Transactional
    public int delete(int orderId, int itemId) {
        OrderDetail orderDetail = orderDetailMapper.selectByPrimaryKey(orderId, itemId);
        if (orderDetail == null) {
            throw new CheckException("This orderDetail not exist.");
        }
        updateOrderPrice(orderDetail.getOrderId(), -orderDetail.getPrice());
        return orderDetailMapper.deleteByPrimaryKey(orderId, itemId);
    }

    @Override
    public OrderDetailView modelToViewModel(OrderDetail orderDetail) {
        OrderDetailView orderDetailView = new OrderDetailView(
            orderDetail.getOrderId(),
            orderDetail.getItemId(),
            orderDetail.getNum(),
            orderDetail.getPrice()
        );
        orderDetailView.setName(dishesService
                .findById(orderDetail.getItemId())
                .getName());
        return orderDetailView;
    }
}
