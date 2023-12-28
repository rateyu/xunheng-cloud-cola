package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.fans.gateway.WoaFansGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Component
public class WoaFansRemoveCmdExe {

    @Resource
    private WoaFansGateway woaFansGateway;

    public void execute(String id) {
        woaFansGateway.remove(id);
    }

}
