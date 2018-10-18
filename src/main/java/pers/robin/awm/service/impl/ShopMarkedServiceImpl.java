package pers.robin.awm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.dao.ShopMarkedMapper;
import pers.robin.awm.model.Shop;
import pers.robin.awm.model.ShopMarked;
import pers.robin.awm.service.ShopMarkedService;

import java.util.List;

@Service
public class ShopMarkedServiceImpl implements ShopMarkedService {

    @Autowired
    private ShopMarkedMapper shopMarkedMapper;

    @Override
    public List<Shop> findByCustomerId(int customerId) {
        return shopMarkedMapper.selectMarked(customerId);
    }

    public boolean markExisted(int customerId, int shopId) {
        return shopMarkedMapper.selectByPrimaryKey(customerId, shopId) != null;
    }

    @Override
    public Integer unMark(int customerId, int shopId) {
        return shopMarkedMapper.updateStatus(customerId, shopId, false);
    }

    @Override
    public Integer mark(int customerId, int shopId) {
        if (markExisted(customerId, shopId)) {
            return shopMarkedMapper.updateStatus(customerId, shopId, true);
        } else {
            ShopMarked shopMarked = new ShopMarked();
            shopMarked.setUserId(customerId);
            shopMarked.setShopId(shopId);
            shopMarked.setStatus(true);
            return shopMarkedMapper.insertSelective(shopMarked);
        }
    }

    @Override
    public Integer create(int customerId, int shopId) {
        return null;
    }
}
