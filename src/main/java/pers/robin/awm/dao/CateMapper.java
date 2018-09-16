package pers.robin.awm.dao;

import pers.robin.awm.model.Cate;

public interface CateMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Cate record);

    int insertSelective(Cate record);

    Cate selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Cate record);

    int updateByPrimaryKey(Cate record);
}