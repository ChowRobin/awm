package pers.robin.awm.dao;

import org.springframework.stereotype.Repository;
import pers.robin.awm.model.Config;

@Repository
public interface ConfigMapper {
    int insert(Config record);

    int insertSelective(Config record);

    int update(Config config);

    Config selectByKey(String key);

    int delete(String key);
}