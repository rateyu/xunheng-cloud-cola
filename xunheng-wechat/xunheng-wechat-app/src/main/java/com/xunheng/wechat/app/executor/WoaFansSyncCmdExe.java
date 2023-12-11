package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.fans.ability.FansDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝同步操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaFansSyncCmdExe {

    @Resource
    FansDomainService fansDomainService;


    public void execute(String appId){
        fansDomainService.syncFans(appId);
    }

}
