package com.xunheng.wechat.domain.msgFeed.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgTemplateEntity;
import com.xunheng.wechat.client.dto.query.WoaMsgTemplatePageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: WoaMsgTemplate网关
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
public interface WoaMsgTemplateGateway {

    /**
     * 消息推送模板分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaMsgTemplateEntity> pageList(WoaMsgTemplatePageQuery query);

    /**
     * 根据id获取消息推送模板信息
     * @param id 消息推送模板id
     * @return 消息推送模板实体
     */
    WoaMsgTemplateEntity getOneById(String id);

    /**
     * 保存或更新消息推送模板实体
     * @param entity 消息推送模板实体
     * @return 消息推送模板实体
     */
    WoaMsgTemplateEntity saveOrUpdate(WoaMsgTemplateEntity entity);

    /**
     * 创建消息推送模板实体
     * @param entity 消息推送模板实体
     * @return 消息推送模板实体
     */
    WoaMsgTemplateEntity create(WoaMsgTemplateEntity entity);

    /**
     * 更新消息推送模板实体
     * @param entity 消息推送模板实体
     * @return 消息推送模板实体
     */
    WoaMsgTemplateEntity update(WoaMsgTemplateEntity entity);

    /**
     * 根据id删除消息推送模板
     * @param id 消息推送模板id
     */
    void remove(String id);

}
