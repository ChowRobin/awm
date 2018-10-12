package pers.robin.awm.dao;

import org.springframework.stereotype.Repository;
import pers.robin.awm.model.WxUser;

@Repository
public interface WxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(WxUser record);

    int insertSelective(WxUser record);

    WxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(WxUser record);

    int updateByPrimaryKey(WxUser record);
}