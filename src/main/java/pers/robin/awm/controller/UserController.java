package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;
import pers.robin.awm.util.CommonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{page_id}")
    public ResultBean<Collection<User>> getUserByCondition(@PathVariable("page_id") Integer pageId,
                                                           HttpServletRequest request) {
        return new ResultBean<Collection<User>>(userService.findByCondition(CommonUtil.getParameterMap(request),
                                                pageId));
    }

    @PostMapping("/create")
    public ResultBean<Integer> create(@RequestBody User user) {
         return new ResultBean<Integer>(userService.create(user));
    }

}
