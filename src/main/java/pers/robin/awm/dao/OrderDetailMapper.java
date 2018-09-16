package pers.robin.awm.dao;

import org.apache.ibatis.annotations.Param;
import pers.robin.awm.model.OrderDetail;

public interface OrderDetailMapper {
    int deleteByPrimaryKey(@Param("orderId") Integer orderId, @Param("itemId") Integer itemId);

    int insert(OrderDetail record);

    int insertSelective(OrderDetail record);

    OrderDetail selectByPrimaryKey(@Param("orderId") Integer orderId, @Param("itemId") Integer itemId);

    int updateByPrimaryKeySelective(OrderDetail record);

    int updateByPrimaryKey(OrderDetail record);
}