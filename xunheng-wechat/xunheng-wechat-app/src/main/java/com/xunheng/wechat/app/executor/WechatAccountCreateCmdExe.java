package com.xunheng.wechat.app.executor;

import com.baomidou.mybatisplus.extension.toolkit.SqlHelper;
import com.xunheng.wechat.app.assembler.WechatAccountAssembler;
import com.xunheng.wechat.client.dto.WechatAccountCreateCmd;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.domain.wechatAccount.ability.WechatAccountDomainService;
import com.xunheng.wechat.domain.wechatAccount.gateway.WechatAccountGateway;
import com.xunheng.wechat.domain.wechatAccount.model.WechatAccountEntity;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号创建处理器
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Slf4j
@Component
public class WechatAccountCreateCmdExe {

    @Resource
    private WechatAccountGateway wechatAccountGateway;

    @Resource
    WechatAccountDomainService wechatAccountDomainService;

    public WechatAccountVO execute(WechatAccountCreateCmd cmd) {
        WechatAccountEntity entity = WechatAccountAssembler.toCreateEntity(cmd);
        /*配置账户信息*/
        wechatAccountDomainService.addAccountToRuntime(entity);
        /*存储信息*/
        return WechatAccountAssembler.toVo(wechatAccountGateway.create(entity));
    }

}
