package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WoaReplyRuleAssembler;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaReplyRuleGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Component
public class WoaReplyRuleDetailQueryExe {
    @Resource
    WoaReplyRuleGateway woaReplyRuleGateway;

    public WoaReplyRuleVO execute(String id) {
        return WoaReplyRuleAssembler.toVo(woaReplyRuleGateway.getOneById(id));
    }
}

