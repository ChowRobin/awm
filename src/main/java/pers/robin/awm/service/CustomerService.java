package pers.robin.awm.service;

import pers.robin.awm.model.Customer;

import java.util.List;
import java.util.Map;

public interface CustomerService {

    List<Customer> findByCondition(Map<String, Object> map, int pageId);

    Customer findById(Integer id);

    int Create(Customer customer);

    int updateById(Customer customer);

    int deleteById(Integer id);

    int register(Customer customer);

    String login(String tel, String password);
}
