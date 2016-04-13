package com.klwork.spring.vertx.configuration.cache;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * Created by young on 15/11/26.
 */
@Configuration
@EnableCaching
@ComponentScan("com.solodream.spring.vertx")
@ConfigurationProperties(locations = "redis.yml", ignoreUnknownFields = false, prefix = "redis")
public class RedisConfig extends CachingConfigurerSupport {
    private String host;
    private int port;

    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    @Bean
    public JedisConnectionFactory redisConnectionFactory() {
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.setUsePool(true);
        jedisConnectionFactory.setHostName(host);
        jedisConnectionFactory.setPort(port);
        return jedisConnectionFactory;
    }

    @Bean
    public RedisSerializer redisStringSerializer() {
        JdkSerializationRedisSerializer stringRedisSerializer = new JdkSerializationRedisSerializer();
        return stringRedisSerializer;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory cf, RedisSerializer redisSerializer) {
        RedisTemplate<Object, Object> redisTemplate = new RedisTemplate<Object, Object>();
        redisTemplate.setConnectionFactory(cf);
        redisTemplate.setDefaultSerializer(redisSerializer);
        return redisTemplate;
    }

    @Bean
    public CacheManager cacheManager() {
        //return new RedisCacheManager(redisTemplate(redisConnectionFactory(), redisStringSerializer()));
        return null;
    }
}
