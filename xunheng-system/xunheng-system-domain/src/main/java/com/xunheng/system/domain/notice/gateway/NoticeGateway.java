package com.xunheng.system.domain.notice.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.query.NoticePageQuery;
import com.xunheng.system.domain.notice.model.NoticeEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:55
 */
public interface NoticeGateway {

    /**
     * 消息通知分页列表
     * @param query 查询条件dto
     * @return 分页列表
     */
    IPage<NoticeEntity> pageList(NoticePageQuery query);

    /**
     * 删除消息通知
     * @param id 消息通知id
     */
    void remove(String id);

    /**
     * 获取未读消息列表
     * @param userId 用户id
     * @return 消息列表
     */
    List<NoticeEntity> getUnReadNoticeList(String userId);

}
