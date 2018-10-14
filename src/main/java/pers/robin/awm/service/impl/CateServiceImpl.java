package pers.robin.awm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.dao.CateMapper;
import pers.robin.awm.model.Cate;
import pers.robin.awm.service.CateService;

import java.util.List;

@Service
public class CateServiceImpl implements CateService {

    @Autowired
    private CateMapper cateMapper;

    @Override
    public List<Cate> findByShopId(int shopId) {
        return cateMapper.selectByShopId(shopId);
    }

    @Override
    public Integer create(Cate cate) {
        cateMapper.insertSelective(cate);
        return cate.getId();
    }

    @Override
    public Integer update(Cate cate) {
        return cateMapper.updateByPrimaryKeySelective(cate);
    }

    @Override
    public Integer delete(Integer id) {
        return cateMapper.deleteByPrimaryKey(id);
    }
}
