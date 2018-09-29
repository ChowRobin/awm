package pers.robin.awm.service.impl;

import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.config.PageConfig;
import pers.robin.awm.dao.CustomerMapper;
import pers.robin.awm.dao.UserMapper;
import pers.robin.awm.model.Customer;
import pers.robin.awm.service.CustomerService;
import pers.robin.awm.service.UserService;

import java.util.List;
import java.util.Map;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private UserService userService;

    @Override
    public List<Customer> findByCondition(Map<String, Object> map, int pageId) {
        PageHelper.startPage(pageId, PageConfig.size);
        return customerMapper.selectByCondition(map);
    }

    @Override
    public Customer findById(Integer id) {
        return customerMapper.selectByPrimaryKey(id);
    }

    @Override
    public int Create(Customer customer) {
        return customerMapper.insertSelective(customer);
    }

    @Override
    public int updateById(Customer customer) {
        return customerMapper.updateByPrimaryKeySelective(customer);
    }

    @Override
    public int deleteById(Integer id) {
        return customerMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int register(Customer customer) {
        customer.setId(userService.create(customer));
        customerMapper.insertSelective(customer);
        return customer.getId();
    }
}
