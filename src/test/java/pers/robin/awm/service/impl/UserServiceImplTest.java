package pers.robin.awm.service.impl;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;

import static org.junit.Assert.*;

public class UserServiceImplTest {

    private UserService userService = new UserServiceImpl();

    @Test
    public void create() {
        User user = new User();
        user.setTel("13655882379");
        user.setPassword("heee");
        user.setRole((short) 0);
        System.out.println(userService.create(user));
    }
}