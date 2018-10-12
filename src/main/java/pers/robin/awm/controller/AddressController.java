package pers.robin.awm.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pers.robin.awm.bean.ResultBean;
import pers.robin.awm.model.Address;
import pers.robin.awm.service.AddressService;

import java.util.Collection;
import java.util.List;

@RestController
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/customer/address/{customer_id}")
    public ResultBean<List<Address>> getCustomerAddress(@PathVariable("customer_id") Integer customerId) {
        return new ResultBean<List<Address>>(addressService.findAdressByCustomerId(customerId));
    }

    @GetMapping("/address/{id}")
    public ResultBean<Address> getAddressById(@PathVariable Integer id) {
        return new ResultBean<>(addressService.findById(id));
    }

    @PostMapping("/customer/address/create/{customer_id}")
    public ResultBean<Integer> createAddress(@RequestBody Address address,
                                             @PathVariable("customer_id") Integer customerId) {
        address.setUserId(customerId);
        return new ResultBean<Integer>(addressService.create(address));
    }

    @PostMapping("/address/update/{id}")
    public ResultBean<Integer> updateAddress(@PathVariable Integer id, @RequestBody Address address) {
        address.setId(id);
        return new ResultBean<>(addressService.updateById(address));
    }

    @GetMapping("/address/delete/{id}")
    public ResultBean<Integer> deleteAddress(@PathVariable Integer id) {
        return new ResultBean<>(addressService.deleteById(id));
    }

}
