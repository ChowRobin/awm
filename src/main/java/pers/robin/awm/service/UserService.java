package pers.robin.awm.service;

import org.springframework.stereotype.Service;
import pers.robin.awm.model.User;

import java.util.List;

public interface UserService {

    List<User> readAll();

    User findById(Integer id);

    int create(User user);

    int updateById(User user);

    int deleteById(Integer id);

}
