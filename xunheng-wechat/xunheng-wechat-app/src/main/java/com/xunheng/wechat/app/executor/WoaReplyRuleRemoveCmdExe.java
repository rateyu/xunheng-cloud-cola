package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.customerService.gateway.WoaReplyRuleGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Component
public class WoaReplyRuleRemoveCmdExe {

    @Resource
    private WoaReplyRuleGateway woaReplyRuleGateway;

    public void execute(String id) {
        woaReplyRuleGateway.remove(id);
    }

}
