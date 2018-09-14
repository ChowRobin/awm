package pers.robin.awm.dao;

import pers.robin.awm.model.dishes;

public interface dishesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(dishes record);

    int insertSelective(dishes record);

    dishes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(dishes record);

    int updateByPrimaryKey(dishes record);
}