package pers.robin.awm.service;

import pers.robin.awm.model.Dishes;
import pers.robin.awm.model.Shop;

import java.util.List;
import java.util.Map;

public interface DishesService {

    List<Dishes> findByCondition(Map<String, Object> map, int pageId);

    Dishes findById(Integer id);

    int create(Dishes dishes);

    int updateById(Dishes dishes);

    int deleteById(Integer id);

    List<Dishes> getDishesByProvider(Integer providerId);
}
