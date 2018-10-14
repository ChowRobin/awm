package pers.robin.awm.dao;

import org.springframework.stereotype.Repository;
import pers.robin.awm.model.Dishes;

import java.util.List;
import java.util.Map;

@Repository
public interface DishesMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Dishes record);

    int insertSelective(Dishes record);

    Dishes selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Dishes record);

    int updateByPrimaryKey(Dishes record);

    List<Dishes> selectByCondition(Map<String, Object> map);
}