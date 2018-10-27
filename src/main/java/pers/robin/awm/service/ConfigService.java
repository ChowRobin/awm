package pers.robin.awm.service;

import pers.robin.awm.model.Config;

public interface ConfigService {

    boolean containsKey(String key);

    String get(String key);

    boolean add(Config config);

    boolean update(Config config);

    boolean delete(String key);
}
