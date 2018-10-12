package pers.robin.awm.service;

import pers.robin.awm.model.Address;

import java.util.List;

public interface AddressService {

    List<Address> findAdressByCustomerId(Integer customerId);

    Address findById(Integer id);

    int create(Address address);

    int updateById(Address address);

    int deleteById(Integer id);

}
