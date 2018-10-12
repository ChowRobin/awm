package pers.robin.awm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.dao.AddressMapper;
import pers.robin.awm.model.Address;
import pers.robin.awm.service.AddressService;

import java.util.List;

@Service
public class AddressServiceImpl implements AddressService {

    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> findAdressByCustomerId(Integer customerId) {
        return addressMapper.selectByUserId(customerId);
    }

    @Override
    public Address findById(Integer id) {
        return addressMapper.selectByPrimaryKey(id);
    }

    @Override
    public int create(Address address) {
        addressMapper.insertSelective(address);
        return address.getId();
    }

    @Override
    public int updateById(Address address) {
        return addressMapper.updateByPrimaryKeySelective(address);
    }

    @Override
    public int deleteById(Integer id) {
        return addressMapper.deleteByPrimaryKey(id);
    }
}
