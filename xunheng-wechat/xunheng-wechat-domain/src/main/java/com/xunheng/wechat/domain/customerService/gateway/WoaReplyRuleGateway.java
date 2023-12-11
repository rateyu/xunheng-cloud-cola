package com.xunheng.wechat.domain.customerService.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.domain.customerService.model.WoaReplyRuleEntity;
import com.xunheng.wechat.client.dto.query.WoaReplyRulePageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: WoaReplyRule网关
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
public interface WoaReplyRuleGateway {

    /**
     * 公众号回复规则分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaReplyRuleEntity> pageList(WoaReplyRulePageQuery query);

    /**
     * 根据id获取公众号回复规则信息
     * @param id 公众号回复规则id
     * @return 公众号回复规则实体
     */
    WoaReplyRuleEntity getOneById(String id);

    /**
     * 保存或更新公众号回复规则实体
     * @param entity 公众号回复规则实体
     * @return 公众号回复规则实体
     */
    WoaReplyRuleEntity saveOrUpdate(WoaReplyRuleEntity entity);

    /**
     * 创建公众号回复规则实体
     * @param entity 公众号回复规则实体
     * @return 公众号回复规则实体
     */
    WoaReplyRuleEntity create(WoaReplyRuleEntity entity);

    /**
     * 更新公众号回复规则实体
     * @param entity 公众号回复规则实体
     * @return 公众号回复规则实体
     */
    WoaReplyRuleEntity update(WoaReplyRuleEntity entity);

    /**
     * 根据id删除公众号回复规则
     * @param id 公众号回复规则id
     */
    void remove(String id);

}
