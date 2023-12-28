package com.xunheng.redis.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @program: xunheng-cloud-cola
 * @description: redis工具类
 * @author: hhqkkr
 * @create: 2021-12-13 16:30
 */
@Component
public class RedisUtil {

    @Resource
    private RedisTemplate<String,String> redisTemplate;


    /**
     * redis序列化配置
     * @param redisTemplate
     */
    @Autowired(required = false)
    public void setRedisTemplate(RedisTemplate redisTemplate) {
        RedisSerializer stringSerializer = new StringRedisSerializer();
        redisTemplate.setKeySerializer(stringSerializer);
        redisTemplate.setValueSerializer(stringSerializer);
        redisTemplate.setHashKeySerializer(stringSerializer);
        redisTemplate.setHashValueSerializer(stringSerializer);
        this.redisTemplate = redisTemplate;
    }

    /**
     * redis赋值
     * @param key 键
     * @param value 值
     */
    public void set(String key,String value){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value);
    }

    /**
     * redis赋值 设定有效时间
     * @param key 键
     * @param value 值
     * @param time 时间长度
     * @param timeUnit 时间类型
     */
    public void set(String key,String value,long time, TimeUnit timeUnit){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        valueOperations.set(key,value,time,timeUnit);
    }

    /**
     * redis取值
     * @param key 键
     * @return 值
     */
    public String get(String key){
        ValueOperations<String,String> valueOperations = redisTemplate.opsForValue();
        return valueOperations.get(key);
    }

    /**
     * redis删除
     * @param key 键
     */
    public void delete(String key){
        redisTemplate.delete(key);
    }

    /**
     * 根据key 获取过期时间
     * @param key 键 不能为null
     * @param timeUnit 时间类型
     * @return 时间 返回0代表为永久有效
     */
    public long getExpire(String key,TimeUnit timeUnit){
        return redisTemplate.getExpire(key,timeUnit);
    }

}
