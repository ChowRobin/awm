package pers.robin.awm.dao;

import pers.robin.awm.model.cate;

public interface cateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(cate record);

    int insertSelective(cate record);

    cate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(cate record);

    int updateByPrimaryKey(cate record);
}