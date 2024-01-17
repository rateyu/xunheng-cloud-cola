package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WechatAccountAssembler;
import com.xunheng.wechat.client.dto.WechatAccountUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.domain.account.ability.AccountDomainService;
import com.xunheng.wechat.domain.account.gateway.WechatAccountGateway;
import com.xunheng.wechat.domain.account.model.WechatAccountEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号更新处理器
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Component
public class WechatAccountUpdateCmdExe {

    @Resource
    private WechatAccountGateway wechatAccountGateway;

    @Resource
    AccountDomainService accountDomainService;

    public WechatAccountVO execute(WechatAccountUpdateCmd cmd) {
        WechatAccountEntity entity = WechatAccountAssembler.toUpdateEntity(cmd);
        /*配置账户信息*/
        accountDomainService.addAccountToRuntime(entity);
        return WechatAccountAssembler.toVo(wechatAccountGateway.update(entity));
    }

}
