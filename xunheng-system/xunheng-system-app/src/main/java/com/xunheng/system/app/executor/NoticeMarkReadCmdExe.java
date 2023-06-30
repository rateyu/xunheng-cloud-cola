package com.xunheng.system.app.executor;


import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.system.domain.notice.gateway.NoticeGateway;
import com.xunheng.system.domain.notice.gateway.NoticeReadGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息标记已读操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:15
 */
@Component
public class NoticeMarkReadCmdExe {

    @Resource
    private NoticeReadGateway noticeReadGateway;

    public void execute(String noticeId) {
        noticeReadGateway.saveNoticeRead(StpUtil.getLoginId().toString(),noticeId);
    }
}
