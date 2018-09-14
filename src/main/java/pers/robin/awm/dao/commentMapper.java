package pers.robin.awm.dao;

import pers.robin.awm.model.comment;

public interface commentMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(comment record);

    int insertSelective(comment record);

    comment selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(comment record);

    int updateByPrimaryKey(comment record);
}