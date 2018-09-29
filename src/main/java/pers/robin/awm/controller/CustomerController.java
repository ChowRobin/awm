package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Customer;
import pers.robin.awm.service.CustomerService;
import pers.robin.awm.util.CommonUtil;

import javax.servlet.http.HttpServletRequest;
import java.util.Collection;

@RequestMapping("/customer")
@RestController
public class CustomerController {

    @Autowired
    CustomerService customerService;

    /**
     *
     * @param pageId
     * @param request
     * @return
     */
    @GetMapping("/{page_id}")
    public ResultBean<Collection<Customer>> getCustomerByCondition(@PathVariable("page_id") Integer pageId,
                                                                   HttpServletRequest request) {
        return new ResultBean<Collection<Customer>>(customerService.findByCondition(CommonUtil.getParameterMap(request),
                                                    pageId));
    }

    @PostMapping(value = "/register")
    public ResultBean<Integer> registerCustomer(@RequestBody Customer customer) {
        return new ResultBean<Integer>(customerService.register(customer));
    }
}
