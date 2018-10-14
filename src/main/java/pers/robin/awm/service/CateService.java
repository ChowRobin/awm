package pers.robin.awm.service;

import pers.robin.awm.model.Cate;

import java.util.List;

public interface CateService {

    List<Cate> findByShopId(int shopId);

    Integer create(Cate cate);

    Integer update(Cate cate);

    Integer delete(Integer id);
}
