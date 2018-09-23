package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;

import java.util.Collection;

@RequestMapping("/user")
@RestController
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/")
    public ResultBean<Collection<User>> getAll() {
        return new ResultBean<Collection<User>>(userService.readAll());
    }

}
