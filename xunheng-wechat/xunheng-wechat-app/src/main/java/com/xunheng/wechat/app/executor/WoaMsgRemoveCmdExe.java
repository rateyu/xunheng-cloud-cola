package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Component
public class WoaMsgRemoveCmdExe {

    @Resource
    private WoaMsgGateway woaMsgGateway;

    public void execute(String id) {
        woaMsgGateway.remove(id);
    }

}
