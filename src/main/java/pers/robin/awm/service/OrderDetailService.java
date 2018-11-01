package pers.robin.awm.service;

import pers.robin.awm.model.OrderDetail;
import pers.robin.awm.viewmodel.OrderDetailView;

import java.util.List;

public interface OrderDetailService {

    List<OrderDetailView> findByOrderId(int orderId);

    int create(OrderDetail orderDetail);

    int update(OrderDetail orderDetail);

    int delete(int orderId, int itemId);

    OrderDetailView modelToViewModel(OrderDetail orderDetail);
}
