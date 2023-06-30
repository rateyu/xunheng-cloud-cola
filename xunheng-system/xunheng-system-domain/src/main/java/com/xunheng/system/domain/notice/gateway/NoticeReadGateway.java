package com.xunheng.system.domain.notice.gateway;


/**
 * @program: xunheng-cloud-cola
 * @description: 消息已读标记网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:56
 */
public interface NoticeReadGateway {

    /**
     * 保存已读标记
     * @param userId 用户id
     * @param noticeId 消息id
     */
    void saveNoticeRead(String userId, String noticeId);
}
