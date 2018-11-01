package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.OrderDetail;
import pers.robin.awm.service.OrderDetailService;
import pers.robin.awm.viewmodel.OrderDetailView;

import java.util.Collection;

@RestController
public class OrderDetailController {

    @Autowired
    private OrderDetailService orderDetailService;

    @GetMapping("/order/details/{order_id}")
    public ResultBean<Collection<OrderDetailView>> getDetailByOrder(@PathVariable("order_id") int orderId) {
        return new ResultBean<>(orderDetailService.findByOrderId(orderId));
    }

    @PostMapping("/order/details/add/{order_id}")
    public ResultBean<Integer> addDetails(@PathVariable("order_id") int orderId,
                                          @RequestBody OrderDetail orderDetail) {
        orderDetail.setOrderId(orderId);
        return new ResultBean<>(orderDetailService.create(orderDetail));
    }

    @PostMapping("/orderdetails/update/{detail_id}")
    public ResultBean<Integer> updateDetails(@PathVariable("detail_id") int detailId,
                                             @RequestBody OrderDetail orderDetail) {
        orderDetail.setItemId(detailId);
        return new ResultBean<>(orderDetailService.update(orderDetail));
    }

    @GetMapping("/order/{order_id}/deletedetail/{detail_id}")
    public ResultBean<Integer> deleteDetails(@PathVariable("order_id") int orderId,
                                             @PathVariable("detail_id") int detailId) {
        return new ResultBean<>(orderDetailService.delete(orderId, detailId));
    }
}
