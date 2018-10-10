package pers.robin.awm.service;

import pers.robin.awm.model.User;

import java.util.List;
import java.util.Map;

public interface UserService {

    List<User> findByCondition(Map<String, Object> map, int pageId);

    User findById(Integer id);

    int create(User user);

    int updateById(User user);

    int deleteById(Integer id);

    User findByTel(String tel);

}
