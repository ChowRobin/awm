package pers.robin.awm.service;

import pers.robin.awm.model.Shop;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

public interface ShopService {

    List<Shop> findByCondition(Map<String, Object> map, int pageId);

    Shop findById(Integer id);

    int Create(Shop shop);

    int updateById(Shop shop);

    int deleteById(Integer id);

    int register(Shop shop);

    String login(String tel, String password);

    Integer getUserIdByToken(HttpServletRequest request);
}
