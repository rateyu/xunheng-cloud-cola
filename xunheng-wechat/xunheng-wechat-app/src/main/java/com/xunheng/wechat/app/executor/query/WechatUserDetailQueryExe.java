package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WechatUserAssembler;
import com.xunheng.wechat.client.dto.VO.WechatUserVO;
import com.xunheng.wechat.domain.wechatUser.gateway.WechatUserGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Component
public class WechatUserDetailQueryExe {
    @Resource
    WechatUserGateway wechatUserGateway;

    public WechatUserVO execute(String id) {
        return WechatUserAssembler.toVo(wechatUserGateway.getOneById(id));
    }
}

