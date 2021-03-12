package com.srw.common.utils;

import org.springframework.data.redis.core.RedisTemplate;

import java.util.concurrent.TimeUnit;

/**
 * @Description:
 * @Author: songrenwei
 * @Date: 2020/12/14/15:47
 */
public class RedisUtils {

    /**
     * redis超时时间
     */
    public static final Long SECOND_FIVE = 5L;

    public static final Long SECOND_TEN = 15L;
    public static final Long HOUR_24 = 24L;

    public static final Long MINUTES_FIVE = 5L;
    public static final Long MINUTES_TEN = 10L;

    private RedisTemplate<String, Object> redisTemplate;

    public RedisUtils(RedisTemplate<String, Object> redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    /**
     * 设置对象
     */
    public <T> void setObject(String key, T clazz) {
        redisTemplate.opsForValue().set(key, clazz);
    }

    /**
     * 设置对象,含有效期,单位为秒
     */
    public <T> void setObject(String key, T clazz, long timeout) {
        redisTemplate.opsForValue().set(key, clazz, timeout, TimeUnit.SECONDS);
    }

    /**
     * 设置对象,含有效期,单位可以自定义
     */
    public <T> void setObject(String key, T clazz, long timeout, TimeUnit unit) {
        redisTemplate.opsForValue().set(key, clazz, timeout, unit);
    }

    public <T> T getObject(String key) {
        return (T) redisTemplate.opsForValue().get(key);
    }

    public void del(String key) {
        if (getObject(key) != null) {
            redisTemplate.delete(key);
        }
    }

    /**
     * redis加锁
     */
    public boolean setKey(String key, String value, Long timeOut, TimeUnit timeUnit) {
        return redisTemplate.opsForValue().setIfAbsent(key, value, timeOut, timeUnit);
    }

    public boolean hasKey(String key) {
        return redisTemplate.hasKey(key);
    }

}
