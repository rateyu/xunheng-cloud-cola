package com.xunheng.wechat.domain.customerService.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.domain.customerService.model.WoaMsgEntity;
import com.xunheng.wechat.client.dto.query.WoaMsgPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: WoaMsg网关
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
public interface WoaMsgGateway {

    /**
     * 公众号消息分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaMsgEntity> pageList(WoaMsgPageQuery query);

    /**
     * 根据id获取公众号消息信息
     * @param id 公众号消息id
     * @return 公众号消息实体
     */
    WoaMsgEntity getOneById(String id);

    /**
     * 保存或更新公众号消息实体
     * @param entity 公众号消息实体
     * @return 公众号消息实体
     */
    WoaMsgEntity saveOrUpdate(WoaMsgEntity entity);

    /**
     * 创建公众号消息实体
     * @param entity 公众号消息实体
     * @return 公众号消息实体
     */
    WoaMsgEntity create(WoaMsgEntity entity);

    /**
     * 更新公众号消息实体
     * @param entity 公众号消息实体
     * @return 公众号消息实体
     */
    WoaMsgEntity update(WoaMsgEntity entity);

    /**
     * 根据id删除公众号消息
     * @param id 公众号消息id
     */
    void remove(String id);

}
