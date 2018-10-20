package pers.robin.awm.controller;

import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Shop;
import pers.robin.awm.model.User;
import pers.robin.awm.service.ShopService;
import pers.robin.awm.util.CommonUtil;
import pers.robin.awm.util.HttpUtil;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;

@RestController
@RequestMapping("/shop")
public class ShopController {

    @Autowired
    ShopService shopService;

    @GetMapping("/{page_id}")
    public ResultBean<Collection<Shop>> getShopByCondition(@PathVariable("page_id") int pageId,
                                                           HttpServletRequest request) {
        return new ResultBean<Collection<Shop>>(shopService.findByCondition(CommonUtil.getParameterMap(request),
                                                pageId));
    }

    @PostMapping(value = "/register")
    public ResultBean<Integer> registerShop(@RequestBody Shop shop) {
        return new ResultBean<Integer>(shopService.register(shop));
    }

    @PostMapping("/update/{id}")
    public ResultBean<Integer> updateShop(@PathVariable Integer id,
                                          @RequestBody Shop shop) {
        shop.setId(id);
        return new ResultBean<Integer>(shopService.updateById(shop));
    }

    @PostMapping("/login")
    public ResultBean<String> login(@RequestBody User user) {
        return new ResultBean<String>(shopService.login(user.getTel(), user.getPassword()));
    }

    @GetMapping("/getuserid")
    public ResultBean<Integer> getUserId(HttpServletRequest request) {
        return new ResultBean<>(shopService.getUserIdByToken(request));
    }

    @GetMapping("/getshopid")
    public ResultBean<Integer> getShopId(HttpServletRequest request) {
        return new ResultBean<>(shopService.getShopIdByToken(request));
    }

    @PostMapping("/avatar/{id}")
    public ResultBean<String> update(@PathVariable int id,
                                     @RequestParam("file")MultipartFile img,
                                     HttpServletRequest request) {
        return new ResultBean<String>(shopService.updateAvatar(shopService.findById(id),
                img, HttpUtil.serverBasePath(request)));
    }

}
