package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Customer;
import pers.robin.awm.service.CustomerService;

import java.util.Collection;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping("/{page_id}")
    public ResultBean<Collection<Customer>> getCustomerByCondition(@PathVariable("page_id") Integer pageId) {
        return new ResultBean<Collection<Customer>>();
    }
}
