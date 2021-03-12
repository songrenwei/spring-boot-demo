package com.srw.business;

import java.util.concurrent.TimeUnit;

/**
 * redis操作Service,
 * 对象和数组都以json形式进行存储
 */
public interface RedisService {
    /**
     * 存储数据
     */
    boolean set(String key, String value, long expireTime, TimeUnit timeUnit);

    /**
     * 获取数据
     */
    String get(String key);

    /**
     * 设置超期时间
     */
    Boolean expire(String key, long expire);

    /**
     * 删除数据
     */
    void remove(String key);

    /**
     * 自增操作
     * @param delta 自增步长
     */
    Long increment(String key, long delta);

}
