package pers.robin.awm.dao;

import org.springframework.stereotype.Repository;
import pers.robin.awm.model.Order;

import java.util.List;
import java.util.Map;

@Repository
public interface OrderMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Integer id);

    List<Order> selectByCondition(Map<String, Object> map);

    List<Order> selectNewOrders(Integer shopId);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}