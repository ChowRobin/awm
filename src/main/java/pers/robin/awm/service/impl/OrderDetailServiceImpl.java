package pers.robin.awm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.dao.OrderDetailMapper;
import pers.robin.awm.model.OrderDetail;
import pers.robin.awm.service.OrderDetailService;

import java.util.List;

@Service
public class OrderDetailServiceImpl implements OrderDetailService {

    @Autowired
    private OrderDetailMapper orderDetailMapper;

    @Override
    public List<OrderDetail> findByOrderId(int orderId) {
        return orderDetailMapper.selectByOrderId(orderId);
    }

    void check(OrderDetail orderDetail) {

    }

    @Override
    public int create(OrderDetail orderDetail) {
        check(orderDetail);
        return orderDetailMapper.insertSelective(orderDetail);
    }

    @Override
    public int update(OrderDetail orderDetail) {
        return orderDetailMapper.updateByPrimaryKeySelective(orderDetail);
    }

    @Override
    public int delete(int orderId, int itemId) {
        return orderDetailMapper.deleteByPrimaryKey(orderId, itemId);
    }
}
