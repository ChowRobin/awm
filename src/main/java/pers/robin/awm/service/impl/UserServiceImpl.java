package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.UserMapper;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findByCondition(Map<String, Object> map, int pageId) {
        PageHelper.startPage(pageId, PageConfig.size);
        return userMapper.selectByCondition(map);
    }

    @Override
    public User findById(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(User user) {
        userMapper.insertSelective(user);
        return user.getId();
    }

    @Override
    public int updateById(User user) {
        return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public int deleteById(Integer id) {
        return userMapper.deleteByPrimaryKey(id);
    }

    @Override
    public User findByTel(String tel) {
        Map map = new HashMap();
        map.put("tel", tel);
        return (User) findByCondition(map, 0).get(0);
    }
}
