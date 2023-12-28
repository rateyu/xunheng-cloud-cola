package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaReplyRuleAssembler;
import com.xunheng.wechat.client.dto.WoaReplyRuleUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaReplyRuleGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则更新处理器
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Component
public class WoaReplyRuleUpdateCmdExe {

    @Resource
    private WoaReplyRuleGateway woaReplyRuleGateway;

    public WoaReplyRuleVO execute(WoaReplyRuleUpdateCmd cmd) {
        return WoaReplyRuleAssembler.toVo(woaReplyRuleGateway.update(WoaReplyRuleAssembler.toUpdateEntity(cmd)));
    }

}
