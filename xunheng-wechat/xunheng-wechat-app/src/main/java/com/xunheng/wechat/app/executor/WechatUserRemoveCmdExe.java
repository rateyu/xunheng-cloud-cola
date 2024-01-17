package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.wechatUser.gateway.WechatUserGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Component
public class WechatUserRemoveCmdExe {

    @Resource
    private WechatUserGateway wechatUserGateway;

    public void execute(String id) {
        wechatUserGateway.remove(id);
    }

}
