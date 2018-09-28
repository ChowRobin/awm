package pers.robin.awm.service;

import pers.robin.awm.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> findByCondition(Map<String, Object> map);

    Customer findById(Integer id);

    int Create(Customer customerj);

    int updateById(Customer customer);

    int deleteById(Integer id);
}
