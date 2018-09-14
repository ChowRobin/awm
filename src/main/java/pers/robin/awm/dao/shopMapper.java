package pers.robin.awm.dao;

import pers.robin.awm.model.shop;

public interface shopMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(shop record);

    int insertSelective(shop record);

    shop selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(shop record);

    int updateByPrimaryKey(shop record);
}