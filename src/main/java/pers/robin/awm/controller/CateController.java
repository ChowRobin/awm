package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Cate;
import pers.robin.awm.service.CateService;

import java.util.Collection;

@RestController
public class CateController {

    @Autowired
    private CateService cateService;

    @GetMapping("/shop/cate/{shop_id}")
    public ResultBean<Collection<Cate>> getCatesByShopId(@PathVariable("shop_id") int shopId) {
        return new ResultBean<Collection<Cate>>(cateService.findByShopId(shopId));
    }

    @PostMapping("/shop/cate/create/{shop_id}")
    public ResultBean<Integer> createCate(@PathVariable("shop_id") int shopId,
                                          @RequestBody Cate cate) {
        cate.setShopId(shopId);
        return new ResultBean<>(cateService.create(cate));
    }

    @PostMapping("/cate/update/{id}")
    public ResultBean<Integer> updateCate(@PathVariable int id, @RequestBody Cate cate) {
        cate.setId(id);
        return new ResultBean<>(cateService.update(cate));
    }

    @GetMapping("/cate/delete/{id}")
    public ResultBean<Integer> deleteCate(@PathVariable int id) {
        return new ResultBean<>(cateService.delete(id));
    }
}
