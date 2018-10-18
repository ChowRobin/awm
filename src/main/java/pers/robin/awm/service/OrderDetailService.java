package pers.robin.awm.service;

import pers.robin.awm.model.OrderDetail;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetail> findByOrderId(int orderId);

    int create(OrderDetail orderDetail);

    int update(OrderDetail orderDetail);

    int delete(int orderId, int itemId);

}
