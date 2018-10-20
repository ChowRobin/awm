package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Dishes;
import pers.robin.awm.service.DishesService;
import pers.robin.awm.util.CommonUtil;
import pers.robin.awm.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RestController
public class DishesController {

    @Autowired
    private DishesService dishesService;

    @GetMapping("/dishes/{page_id}")
    public ResultBean<Collection<Dishes>> getDishesByCondition(@PathVariable("page_id") int pageId,
                                                               HttpServletRequest request) {
        return new ResultBean<Collection<Dishes>>(dishesService.findByCondition(CommonUtil.getParameterMap(request),
                                                                                pageId));
    }

    @GetMapping("/shop/dishes/{shop_id}")
    public ResultBean<Collection<Dishes>> getDishesListByProvider(@PathVariable("shop_id") int shopId) {
        return new ResultBean<Collection<Dishes>>(dishesService.getDishesByProvider(shopId));
    }

    @PostMapping("/shop/dishes/create/{shop_id}")
    public ResultBean<Integer> createDishes(@RequestBody Dishes dishes,
                                            @PathVariable("shop_id") int shopId) {
        dishes.setProvider(shopId);
        return new ResultBean<Integer>(dishesService.create(dishes));
    }

    @PostMapping("/dishes/update/{id}")
    public ResultBean<Integer> updateDishes(@PathVariable int id, @RequestBody Dishes dishes) {
        dishes.setId(id);
        return new ResultBean<>(dishesService.updateById(dishes));
    }

    @GetMapping("/dishes/delete/{id}")
    public ResultBean<Integer> deleteDishes(@PathVariable int id) {
        return new ResultBean<>(dishesService.deleteById(id));
    }

    @PostMapping("/dishes/img/{id}")
    public ResultBean<String> update(@PathVariable int id,
                                     @RequestParam("file")MultipartFile img,
                                     HttpServletRequest request) {
        return new ResultBean<String>(dishesService.updateImg(dishesService.findById(id),
                img, HttpUtil.serverBasePath(request)));
    }
}
