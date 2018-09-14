package pers.robin.awm.dao;

import org.apache.ibatis.annotations.Param;
import pers.robin.awm.model.shopMarked;

public interface shopMarkedMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    int insert(shopMarked record);

    int insertSelective(shopMarked record);

    shopMarked selectByPrimaryKey(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    int updateByPrimaryKeySelective(shopMarked record);

    int updateByPrimaryKey(shopMarked record);
}