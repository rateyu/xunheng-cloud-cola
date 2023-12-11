package com.xunheng.wechat.domain.fans.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;
import com.xunheng.wechat.domain.fans.model.WoaFansEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: WoaFans网关
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public interface WoaFansGateway {

    /**
     * 公众号粉丝分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaFansEntity> pageList(WoaFansPageQuery query);

    /**
     * 根据id获取公众号粉丝信息
     * @param id 公众号粉丝id
     * @return 公众号粉丝实体
     */
    WoaFansEntity getOneById(String id);

    /**
     * 根据openId获取公众号粉丝信息
     * @param openId 公众号粉丝openId
     * @return 公众号粉丝实体
     */
    WoaFansEntity getOneByOpenId(String openId);

    /**
     * 保存或更新公众号粉丝实体
     * @param entity 公众号粉丝实体
     * @return 公众号粉丝实体
     */
    WoaFansEntity saveOrUpdate(WoaFansEntity entity);

    /**
     * 创建公众号粉丝实体
     * @param entity 公众号粉丝实体
     * @return 公众号粉丝实体
     */
    WoaFansEntity create(WoaFansEntity entity);

    /**
     * 更新公众号粉丝实体
     * @param entity 公众号粉丝实体
     * @return 公众号粉丝实体
     */
    WoaFansEntity update(WoaFansEntity entity);

    /**
     * 根据id删除公众号粉丝
     * @param id 公众号粉丝id
     */
    void remove(String id);

}
