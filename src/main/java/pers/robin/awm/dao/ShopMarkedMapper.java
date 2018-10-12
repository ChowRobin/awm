package pers.robin.awm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.robin.awm.model.ShopMarked;

@Repository
public interface ShopMarkedMapper {
    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    int insert(ShopMarked record);

    int insertSelective(ShopMarked record);

    ShopMarked selectByPrimaryKey(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    int updateByPrimaryKeySelective(ShopMarked record);

    int updateByPrimaryKey(ShopMarked record);
}