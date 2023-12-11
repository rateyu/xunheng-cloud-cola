package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Component
public class WoaMsgTemplateRemoveCmdExe {

    @Resource
    private WoaMsgTemplateGateway woaMsgTemplateGateway;

    public void execute(String id) {
        woaMsgTemplateGateway.remove(id);
    }

}
