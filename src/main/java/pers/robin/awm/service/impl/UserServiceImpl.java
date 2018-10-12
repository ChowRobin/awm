package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import com.sun.tools.javac.comp.Check;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.UserMapper;
import pers.robin.awm.exception.CheckException;
import pers.robin.awm.model.User;
import pers.robin.awm.service.UserService;
import pers.robin.awm.util.JWTUtil;

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

    private void check(User user) {
        if (user.getTel() == null || user.getPassword() == null) {
            throw new CheckException("Tel or Password can not be null");
        }
    }

    @Override
    public int create(User user) {
        check(user);
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
        System.out.println("user try to auth, tel is " + tel);
        List<User> list = findByCondition(map, 0);
        if (list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public String login(String tel, String password) {
        User user = findByTel(tel);
        if (user == null) {
            throw new CheckException("tel is not register");
        }

        if (user.getPassword().equals(password)) {
            return JWTUtil.sign(tel, password);
        } else {
            throw new CheckException("password is not current");
        }
    }

}
