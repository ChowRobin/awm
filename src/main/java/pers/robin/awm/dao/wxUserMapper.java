package pers.robin.awm.dao;

import pers.robin.awm.model.wxUser;

public interface wxUserMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(wxUser record);

    int insertSelective(wxUser record);

    wxUser selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(wxUser record);

    int updateByPrimaryKey(wxUser record);
}