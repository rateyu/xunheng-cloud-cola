
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.notice.gateway.NoticeGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:16
 */
@Component
public class NoticeRemoveCmdExe {
    @Resource
    private NoticeGateway noticeGateway;

    public void execute(String id) {
        noticeGateway.remove(id);
    }

}
