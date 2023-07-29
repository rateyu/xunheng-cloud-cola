package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.wechatAccount.ability.WechatAccountDomainService;
import com.xunheng.wechat.domain.wechatAccount.gateway.WechatAccountGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号删除操作处理器
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Component
public class WechatAccountRemoveCmdExe {

    @Resource
    WechatAccountDomainService wechatAccountDomainService;

    @Resource
    private WechatAccountGateway wechatAccountGateway;

    public void execute(String id) {
        wechatAccountDomainService.removeConfig(id);
        wechatAccountGateway.remove(id);
    }

}
