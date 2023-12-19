package com.xunheng.wechat.domain.msgFeed.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgFeedRecordEntity;
import com.xunheng.wechat.client.dto.query.WoaMsgFeedRecordPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: WoaMsgFeedRecord网关
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
public interface WoaMsgFeedRecordGateway {

    /**
     * 消息推送日志分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaMsgFeedRecordEntity> pageList(WoaMsgFeedRecordPageQuery query);

    /**
     * 根据id获取消息推送日志信息
     * @param id 消息推送日志id
     * @return 消息推送日志实体
     */
    WoaMsgFeedRecordEntity getOneById(String id);

    /**
     * 保存或更新消息推送日志实体
     * @param entity 消息推送日志实体
     * @return 消息推送日志实体
     */
    WoaMsgFeedRecordEntity saveOrUpdate(WoaMsgFeedRecordEntity entity);

    /**
     * 创建消息推送日志实体
     * @param entity 消息推送日志实体
     * @return 消息推送日志实体
     */
    WoaMsgFeedRecordEntity create(WoaMsgFeedRecordEntity entity);

    /**
     * 更新消息推送日志实体
     * @param entity 消息推送日志实体
     * @return 消息推送日志实体
     */
    WoaMsgFeedRecordEntity update(WoaMsgFeedRecordEntity entity);

    /**
     * 根据id删除消息推送日志
     * @param id 消息推送日志id
     */
    void remove(String id);

}
