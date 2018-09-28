package pers.robin.awm.service.impl;

import org.springframework.stereotype.Service;
import pers.robin.awm.model.Customer;
import pers.robin.awm.service.CustomerService;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> findByCondition(Map<String, Object> map) {
        return null;
    }

    @Override
    public Customer findById(Integer id) {
        return null;
    }

    @Override
    public int Create(Customer customerj) {
        return 0;
    }

    @Override
    public int updateById(Customer customer) {
        return 0;
    }

    @Override
    public int deleteById(Integer id) {
        return 0;
    }
}
