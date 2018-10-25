package pers.robin.awm.util;

import org.apache.log4j.Logger;
import org.apache.ibatis.cache.Cache;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class RedisCache implements Cache {

    private static final Logger logger = Logger.getLogger(RedisCache.class);

    private final ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    private final String id;
    private RedisTemplate redisTemplate;

    // redis过期时间
    private static final long EXPIRE_TIME_IN_MINUTES = 30;

    public RedisCache(String id) {
        if (id == null) {
            throw new IllegalArgumentException("Cache instances require an ID");
        }
        this.id = id;
    }

    @Override
    public String getId() {
        return id;
    }

    @Override
    public void putObject(Object key, Object value) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            ValueOperations valueOperations = redisTemplate.opsForValue();
            valueOperations.set(key, value, EXPIRE_TIME_IN_MINUTES, TimeUnit.MINUTES);
        } catch (Throwable throwable) {
            logger.error("Redis put failed", throwable);
        }
    }

    @Override
    public Object getObject(Object key) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            ValueOperations valueOperations = redisTemplate.opsForValue();
            logger.debug("Get cached query result from redis");
            return valueOperations.get(key);
        } catch (Throwable throwable) {
            logger.error("Redis get failed, fail over to db", throwable);
            return null;
        }
    }

    @Override
    public Object removeObject(Object key) {
        try {
            RedisTemplate redisTemplate = getRedisTemplate();
            redisTemplate.delete(key);
            logger.debug("Remove cached query result from redis");
        } catch (Throwable throwable) {
            logger.error("Redis remove failed", throwable);
        }
        return null;
    }

    @Override
    public void clear() {
        RedisTemplate redisTemplate = getRedisTemplate();
        redisTemplate.execute((RedisCallback) connection -> {
            connection.flushDb();
            return null;
        });
        logger.debug("Clear all the cached query result from redis");
    }

    @Override
    public int getSize() {
        return 0;
    }

    @Override
    public ReadWriteLock getReadWriteLock() {
        return readWriteLock;
    }

    private RedisTemplate getRedisTemplate() {
        if (redisTemplate == null) {
            redisTemplate = ApplicationContextHolder.getBean("redisTemplate");
        }
        return redisTemplate;
    }
}
