package pers.robin.awm.service;

import pers.robin.awm.model.Shop;

import java.util.List;

public interface ShopMarkedService {

    List<Shop> findByCustomerId(int customerId);

    Integer unMark(int customerId, int shopId);

    Integer mark(int customerId, int shopId);

    Integer create(int customerId, int shopId);
}
