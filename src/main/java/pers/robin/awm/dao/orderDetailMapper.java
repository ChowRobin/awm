package pers.robin.awm.dao;

import org.apache.ibatis.annotations.Param;
import pers.robin.awm.model.orderDetail;

public interface orderDetailMapper {
    int deleteByPrimaryKey(@Param("orderId") Integer orderId, @Param("itemId") Integer itemId);

    int insert(orderDetail record);

    int insertSelective(orderDetail record);

    orderDetail selectByPrimaryKey(@Param("orderId") Integer orderId, @Param("itemId") Integer itemId);

    int updateByPrimaryKeySelective(orderDetail record);

    int updateByPrimaryKey(orderDetail record);
}