package pers.robin.awm.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pers.robin.awm.dao.ConfigMapper;
import pers.robin.awm.model.Config;
import pers.robin.awm.service.ConfigService;

@Service
public class ConfigServiceImpl implements ConfigService {

    @Autowired
    private ConfigMapper configMapper;

    @Override
    public boolean containsKey(String key) {
        return configMapper.selectByKey(key) != null;
    }

    @Override
    public String get(String key) {
        Config config = configMapper.selectByKey(key);
        return config != null ? config.getValue() : null;
    }

    @Override
    public boolean add(Config config) {
        if (containsKey(config.getKey())) {
            return false;
        }
        configMapper.insert(config);
        return true;
    }

    @Override
    public boolean update(Config config) {
        configMapper.update(config);
        return true;
    }

    @Override
    public boolean delete(String key) {
        configMapper.delete(key);
        return true;
    }
}
