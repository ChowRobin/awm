package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Order;
import pers.robin.awm.service.OrderService;
import pers.robin.awm.util.CommonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{page_id}")
    public ResultBean<List<Order>> getOrderByCondition(@PathVariable("page_id") int pageId,
                                                 HttpServletRequest request) {
        return new ResultBean<List<Order>>(orderService.findByCondition(CommonUtil.getParameterMap(request)));
    }

    @GetMapping("/shop/getneworders/{shop_id}")
    public ResultBean<List<Order>> getNewOrdersByShop(@PathVariable("shop_id") int shopId) {
        return new ResultBean<>(orderService.getNewOrders(shopId));
    }

    @PostMapping("/customer/order/{customer_id}")
    public ResultBean<Integer> createOrder(@PathVariable("customer_id") int customerId,
                                           @RequestBody Order order) {
        order.setUserId(customerId);
        return new ResultBean<>(orderService.create(order));
    }

    @GetMapping("/order/{id}/pay")
    public ResultBean<Integer> payForOrder(@PathVariable int id) {
        return new ResultBean<>(orderService.pay(id));
    }

    @GetMapping("/order/{id}/cancel")
    public ResultBean<Integer> cancelByCustomer(@PathVariable int id) {
        return new ResultBean<>(orderService.cancelByCustomer(id));
    }

    @GetMapping("/order/{id}/complete")
    public ResultBean<Integer> complete(@PathVariable int id) {
        return new ResultBean<>(orderService.complete(id));
    }

}
