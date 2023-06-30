package com.xunheng.system.infrastructure.gateway.impl;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.redis.util.RedisUtil;
import com.xunheng.system.domain.sasession.gateway.SaSessionGateway;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: sasession 网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:43
 */
@Slf4j
@Component
public class SaSessionGatewayImpl implements SaSessionGateway {

    @Resource
    RedisUtil redisUtil;

    @Resource
    ApplicationContext applicationContext;

    @Override
    public void cleanExpiredTokenSession() {
        String activityTimeoutStr = applicationContext.getEnvironment().getProperty("sa-token.activity-timeout");
        List<String> allTokenSessions = StpUtil.searchTokenSessionId("", -1, 9999); //查询所有tokenSessions
        for (String tokenSession : allTokenSessions) {
            String keyLastActivityTime =  tokenSession.replace("token-session","last-activity");
            String keytoken =  tokenSession.replace("token-session","token");
            String lastActivityTimeString = redisUtil.get(keyLastActivityTime);
            if (lastActivityTimeString == null) {//获取不到的清除掉session里的信息
                redisUtil.delete(tokenSession);
                redisUtil.delete(keyLastActivityTime);
                redisUtil.delete(keytoken);
            } else {
                long lastActivityTime = Long.parseLong(lastActivityTimeString);
                long apartSecond = (System.currentTimeMillis() - lastActivityTime) / 1000L;
                long timeout = Long.parseLong(activityTimeoutStr) - apartSecond;
                if(timeout < 0){
                    redisUtil.delete(tokenSession);
                    redisUtil.delete(keyLastActivityTime);
                    redisUtil.delete(keytoken);
                }
            }
        }
    }
}
