package pers.robin.awm.dao;

import pers.robin.awm.model.Config;

public interface ConfigMapper {
    int insert(Config record);

    int insertSelective(Config record);
}