package pers.robin.awm.dao;

import org.springframework.stereotype.Repository;
import pers.robin.awm.model.Customer;

import java.util.List;
import java.util.Map;

@Repository
public interface CustomerMapper {

    int deleteByPrimaryKey(Integer id);

    int insert(Customer record);

    int insertSelective(Customer record);

    Customer selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Customer record);

    int updateByPrimaryKey(Customer record);

    List<Customer> selectByCondition(Map<String, Object> map);
}