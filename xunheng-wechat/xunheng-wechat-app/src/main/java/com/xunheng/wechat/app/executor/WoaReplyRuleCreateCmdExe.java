package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaReplyRuleAssembler;
import com.xunheng.wechat.client.dto.WoaReplyRuleCreateCmd;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaReplyRuleGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则创建处理器
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Component
public class WoaReplyRuleCreateCmdExe {

    @Resource
    private WoaReplyRuleGateway woaReplyRuleGateway;

    public WoaReplyRuleVO execute(WoaReplyRuleCreateCmd cmd) {
        return WoaReplyRuleAssembler.toVo(woaReplyRuleGateway.create(WoaReplyRuleAssembler.toCreateEntity(cmd)));
    }

}
