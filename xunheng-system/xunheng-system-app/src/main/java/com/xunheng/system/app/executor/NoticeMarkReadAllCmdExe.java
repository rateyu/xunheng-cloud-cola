package com.xunheng.system.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.system.domain.notice.gateway.NoticeGateway;
import com.xunheng.system.domain.notice.gateway.NoticeReadGateway;
import com.xunheng.system.domain.notice.model.NoticeEntity;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 标记所有信息已读操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:14
 */
@Component
public class NoticeMarkReadAllCmdExe {

    @Resource
    private NoticeGateway noticeGateway;

    @Resource
    private NoticeReadGateway noticeReadGateway;

    public void execute() {
        /*获取当前用户的未读信息列表*/
        String userId = StpUtil.getLoginId("-1");
        List<NoticeEntity> unReadNoticeList = noticeGateway.getUnReadNoticeList(userId);
        /*遍历进行已读标记*/
        unReadNoticeList.forEach(notice -> noticeReadGateway.saveNoticeRead(userId,notice.getId()));
    }
}
