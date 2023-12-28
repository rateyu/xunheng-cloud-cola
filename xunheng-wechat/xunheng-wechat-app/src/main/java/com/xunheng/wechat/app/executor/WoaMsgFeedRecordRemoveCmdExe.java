package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgFeedRecordGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Component
public class WoaMsgFeedRecordRemoveCmdExe {

    @Resource
    private WoaMsgFeedRecordGateway woaMsgFeedRecordGateway;

    public void execute(String id) {
        woaMsgFeedRecordGateway.remove(id);
    }

}
