package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Order;
import pers.robin.awm.service.OrderService;
import pers.robin.awm.util.CommonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping("/order/{page_id}")
    public ResultBean<List<Order>> getOrderByCondition(@PathVariable("page_id") int pageId,
                                                 HttpServletRequest request) {
        return new ResultBean<List<Order>>(orderService.findByCondition(CommonUtil.getParameterMap(request), pageId));
    }

    @GetMapping("/shop/getneworders/{shop_id}")
    public ResultBean<List<Order>> getNewOrdersByShop(@PathVariable("shop_id") int shopId) {
        return new ResultBean<>(orderService.getNewOrders(shopId));
    }

    @GetMapping("/shop/{shop_id}/getorders/{page_id}")
    public ResultBean<List<Order>> getOrdersByShop(@PathVariable("shop_id") int shopId,
                                                   @PathVariable("page_id") int pageId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("provider", shopId);
        return new ResultBean<>(orderService.findByCondition(map, pageId));
    }

    @GetMapping("/customer/{customer_id}/getorders/{page_id}")
    public ResultBean<List<Order>> getOrdersByCustomer(@PathVariable("customer_id") int customerId,
                                                   @PathVariable("page_id") int pageId) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("userId", customerId);
        return new ResultBean<>(orderService.findByCondition(map, pageId));
    }

    @PostMapping("/customer/createorder/{customer_id}")
    public ResultBean<Integer> createOrder(@PathVariable("customer_id") int customerId,
                                           @RequestBody Order order) {
        order.setUserId(customerId);
        return new ResultBean<>(orderService.create(order));
    }

    @GetMapping("/order/{id}/accept")
    public ResultBean<Integer> acceptByShop(@PathVariable int id) {
        return new ResultBean<>(orderService.accept(id));
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
