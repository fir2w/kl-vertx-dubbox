package com.klwork.spring.vertx.service;

import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisOperations;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.ZonedDateTime;
import java.time.temporal.ChronoUnit;
import java.util.Date;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by young on 15/11/26.
 */
@Service
public class RedisCacheService {
    @Resource(name = "redisTemplate")
    private ListOperations<String, String> messageList;
    @Resource(name = "redisTemplate")
    private RedisOperations<String, String> latestMessageExpiration;
    @Resource(name = "redisTemplate")
    private ValueOperations<String, String> kvstore;
    @Resource(name = "redisTemplate")
    private ValueOperations<String, Object> keyValueStore;

    public void putObject(String key, Object value) {
        keyValueStore.set(key, value);
    }

    public Object getObject(String key) {
        return keyValueStore.get(key);
    }


    public void put(String key, String value) {
        kvstore.set(key, value);
    }


    public void put(String key, String value, long expire) {
        kvstore.set(key, value, expire, TimeUnit.SECONDS);
    }

    public String get(String key) {
        return kvstore.get(key);
    }


    public Set<String> keys(String pattern) {
        return latestMessageExpiration.keys(pattern);
    }

    public void addMessage(String user, String message) {
        messageList.leftPush(user, message);
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        Date date = Date.from(zonedDateTime.plus(3, ChronoUnit.MINUTES).toInstant());
        latestMessageExpiration.expireAt(user, date);
    }

    public List<String> listMessages(String user) {
        return messageList.range(user, 0, -1);
    }
}