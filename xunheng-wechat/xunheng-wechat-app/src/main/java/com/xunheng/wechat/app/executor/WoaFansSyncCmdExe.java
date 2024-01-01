package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.wechatUser.ability.WechatUserDomainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户同步操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaFansSyncCmdExe {

    @Resource
    WechatUserDomainService wechatUserDomainService;


    public void execute(String appId){
        wechatUserDomainService.syncFans(appId);
    }

}
