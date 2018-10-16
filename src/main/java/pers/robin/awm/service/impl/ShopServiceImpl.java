package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import org.apache.shiro.crypto.hash.Hash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.ShopMapper;
import pers.robin.awm.exception.CheckException;
import pers.robin.awm.model.Shop;
import pers.robin.awm.model.User;
import pers.robin.awm.service.ShopService;
import pers.robin.awm.service.UserService;
import pers.robin.awm.util.JWTUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class ShopServiceImpl implements ShopService {

    @Autowired
    private ShopMapper shopMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<Shop> findByCondition(Map<String, Object> map, int pageId) {
        PageHelper.startPage(pageId, PageConfig.size);
        return shopMapper.selectByCondition(map);
    }

    @Override
    public Shop findById(Integer id) {
        return shopMapper.selectByPrimaryKey(id);
    }

    private void check(Shop shop) {
        if (shop.getName() == null) {
            throw new CheckException("shop name can not be null");
        } else if (shop.getUserId() == null) {
            throw new CheckException("userid can not be null");
        }
    }

    @Override
    public int create(Shop shop) {
        check(shop);
        return shopMapper.insertSelective(shop);
    }

    @Override
    public int updateById(Shop shop) {
        return shopMapper.updateByPrimaryKeySelective(shop);
    }

    @Override
    public int deleteById(Integer id) {
        return shopMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int register(Shop shop) {
        check(shop);
        shopMapper.insertSelective(shop);
        return shop.getId();
    }

    @Override
    public String login(String tel, String password) {
        return userService.login(tel, password);
    }

    @Override
    public Integer getUserIdByToken(HttpServletRequest request) {
        String tel = JWTUtil.getTel(request.getHeader("Authorization"));
        User user = userService.findByTel(tel);
        if (user == null) {
            throw new CheckException("user is not exists");
        }
        return user.getId();
    }

    @Override
    public Integer getShopIdByToken(HttpServletRequest request) {
        int userId = getUserIdByToken(request);
        HashMap<String, Object> map = new HashMap<String, Object>();
        map.put("userId", userId);
        List<Shop> list = findByCondition(map, 1);
        if (list.size() >= 1) {
            return list.get(0).getId();
        }
        return null;
    }
}
