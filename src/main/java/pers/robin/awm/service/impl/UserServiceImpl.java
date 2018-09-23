package pers.robin.awm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.dao.UserMapper;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> readAll() {
        return userMapper.selectAll();
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(User user) {
        return userMapper.insertSelective(user);
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }
}
