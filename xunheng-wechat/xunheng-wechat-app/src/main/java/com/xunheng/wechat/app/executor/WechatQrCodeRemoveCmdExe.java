package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.account.gateway.WechatQrCodeGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Component
public class WechatQrCodeRemoveCmdExe {

    @Resource
    private WechatQrCodeGateway wechatQrCodeGateway;

    public void execute(String id) {
        wechatQrCodeGateway.remove(id);
    }

}
