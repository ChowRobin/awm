package pers.robin.awm.dao;

import pers.robin.awm.model.address;

public interface addressMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(address record);

    int insertSelective(address record);

    address selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(address record);

    int updateByPrimaryKey(address record);
}