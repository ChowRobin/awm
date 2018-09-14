package pers.robin.awm.dao;

import pers.robin.awm.model.config;

public interface configMapper {
    int insert(config record);

    int insertSelective(config record);
}