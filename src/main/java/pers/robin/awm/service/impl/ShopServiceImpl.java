package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.ShopMapper;
import pers.robin.awm.model.Shop;
import pers.robin.awm.service.ShopService;
import pers.robin.awm.service.UserService;

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

    @Override
    public int Create(Shop shop) {
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
        shopMapper.insertSelective(shop);
        return shop.getId();
    }

    @Override
    public String login(String tel, String password) {
        return userService.login(tel, password);
    }
}
