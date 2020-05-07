package com.example.redis2.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.RedisSerializer;

import javax.annotation.PostConstruct;
import java.time.Duration;

@Configuration
public class RedisTemplateConfig {

    @Autowired
    RedisTemplate redisTemplate=null;

    //定义自定义后初始方法
    @PostConstruct
    public void init(){
        initRedisTemplate();
    }

    //设置template序列化器
    private void initRedisTemplate() {
        RedisSerializer serializer=redisTemplate.getStringSerializer();
        redisTemplate.setKeySerializer(serializer);
        redisTemplate.setHashKeySerializer(serializer);
    }

    @Autowired
    private RedisConnectionFactory connectionFactory = null;

    @Bean(name = "redisCacheManager" )
    public RedisCacheManager initRedisCacheManager() {
        // Redis加锁的写入器
        RedisCacheWriter writer= RedisCacheWriter.lockingRedisCacheWriter(connectionFactory);
        // 启动Redis缓存的默认设置
        RedisCacheConfiguration config = RedisCacheConfiguration.defaultCacheConfig();
        // 设置JDK序列化器
        config = config.serializeValuesWith(RedisSerializationContext.SerializationPair.fromSerializer(new JdkSerializationRedisSerializer()));
        // 禁用前缀
        config = config.disableKeyPrefix();
        //设置10分钟超时
        config = config.entryTtl(Duration.ofMinutes(10));
        // 创建缓Redis存管理器
        RedisCacheManager redisCacheManager = new RedisCacheManager(writer, config);
        return redisCacheManager;
    }


}
