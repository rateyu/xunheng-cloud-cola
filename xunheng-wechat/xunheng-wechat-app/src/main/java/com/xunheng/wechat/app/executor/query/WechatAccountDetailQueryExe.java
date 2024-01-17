package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WechatAccountAssembler;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.domain.account.gateway.WechatAccountGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号详情查询处理器
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Component
public class WechatAccountDetailQueryExe {
    @Resource
    WechatAccountGateway wechatAccountGateway;

    public WechatAccountVO execute(String id) {
        return WechatAccountAssembler.toVo(wechatAccountGateway.getOneById(id));
    }
}

