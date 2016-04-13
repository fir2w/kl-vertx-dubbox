package com.klwork.spring.vertx.service;

import java.util.Set;

/**
 * Created by young on 15/11/25.
 */
public interface CacheService {

    public <T> boolean set(String key, T value);

    public <T> boolean set(String key, T value, int expire);

    public <T> T get(String key,Class<T> clazz);

    /**
     *
     * @param key
     * @param value
     * @param score 排序分
     * @TODDO 有序集合添加。
     * @return
     */
    public boolean zadd(String key, String value, long score);

    /**
     * @TODO 获取有序集合所有成员
     * @param key
     * @param startSocre
     * @param endSocre
     * @return
     */
    public Set<String> zrange(String key ,long startSocre , long endSocre);

    public boolean delete(String key);
}