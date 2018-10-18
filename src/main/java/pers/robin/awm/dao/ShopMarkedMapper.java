package pers.robin.awm.dao;

import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import pers.robin.awm.model.Shop;
import pers.robin.awm.model.ShopMarked;

import java.util.List;

@Repository
public interface ShopMarkedMapper {

    List<Shop> selectMarked(int userId);

    int deleteByPrimaryKey(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    int insert(ShopMarked record);

    int insertSelective(ShopMarked record);

    ShopMarked selectByPrimaryKey(@Param("userId") Integer userId, @Param("shopId") Integer shopId);

    int updateByPrimaryKeySelective(ShopMarked record);

    int updateByPrimaryKey(ShopMarked record);

    Integer updateStatus(int customerId, int shopId, boolean status);
}