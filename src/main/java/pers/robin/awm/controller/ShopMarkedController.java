package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Shop;
import pers.robin.awm.service.ShopMarkedService;

import java.util.Collection;

@RestController
public class ShopMarkedController {

    @Autowired
    private ShopMarkedService shopMarkedService;

    @GetMapping("/customer/getmarked/{customer_id}")
    public ResultBean<Collection<Shop>> getMarkedShops(@PathVariable("customer_id") int customerId) {
        return new ResultBean<>(shopMarkedService.findByCustomerId(customerId));
    }

    @GetMapping("/customer/{customer_id}/mark/{shop_id}")
    public ResultBean<Integer> markShop(@PathVariable("customer_id") int customerId,
                                        @PathVariable("shop_id") int shopId) {
        return new ResultBean<>(shopMarkedService.mark(customerId, shopId));
    }

    @GetMapping("/customer/{customer_id}/unmark/{shop_id}")
    public ResultBean<Integer> unMarkShop(@PathVariable("customer_id") int customerId,
                                          @PathVariable("shop_id") int shopId) {
        return new ResultBean<>(shopMarkedService.unMark(customerId, shopId));
    }
}

