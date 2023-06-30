package com.xunheng.security.config.util;

import cn.dev33.satoken.SaManager;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.core.Cursor;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ScanOptions;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashSet;
import java.util.Set;

/**
 * @program: xunheng-cloud-cola
 * @description: 解决一些satoken无法处理的问题
 * @author: hhqkkr
 * @create: 2022-01-12 12:47
 */
@Component
@Slf4j
public class SaUtil{
    @Resource
    public RedisTemplate<String, Object> redisTemplate;

    public void deleteCustomerSession(String patternKey){
        Set<String> keys = scanTargetKeys(splicingSessionKey(patternKey));
        for (String key : keys) {
            Boolean delete = redisTemplate.delete(key);
            log.info(delete+"");
        }
    }


    private Set<String> scanTargetKeys(String keyWords){
        return redisTemplate.execute((RedisCallback<Set<String>>) connection -> {
            Set<String> keysTmp = new HashSet<>();
            Cursor<byte[]> cursor = connection.scan(
                    new ScanOptions.ScanOptionsBuilder().match(
                            keyWords
                    ).count(10000).build()
            );

            while (cursor.hasNext()){
                keysTmp.add(new String(cursor.next()));
            }

            return keysTmp;
        });
    }

    public static String splicingSessionKey(String patternKey) {
        return SaManager.getConfig().getTokenName() + ":custom:session:" + patternKey;
    }
}
