package com.xunheng.wechat.domain.wechatUser.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.query.WechatUserPageQuery;
import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: WechatUser网关
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public interface WechatUserGateway {

    /**
     * 微信用户分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WechatUserEntity> pageList(WechatUserPageQuery query);

    /**
     * 根据id获取微信用户信息
     * @param id 微信用户id
     * @return 微信用户实体
     */
    WechatUserEntity getOneById(String id);

    /**
     * 根据openId获取微信用户信息
     * @param appId 应用id
     * @param openId 微信用户openId
     * @return 微信用户实体
     */
    WechatUserEntity getOneByOpenId(String appId,String openId);

    /**
     * 保存或更新微信用户实体
     * @param entity 微信用户实体
     * @return 微信用户实体
     */
    WechatUserEntity saveOrUpdate(WechatUserEntity entity);

    /**
     * 创建微信用户实体
     * @param entity 微信用户实体
     * @return 微信用户实体
     */
    WechatUserEntity create(WechatUserEntity entity);

    /**
     * 更新微信用户实体
     * @param entity 微信用户实体
     * @return 微信用户实体
     */
    WechatUserEntity update(WechatUserEntity entity);

    /**
     * 根据id删除微信用户
     * @param id 微信用户id
     */
    void remove(String id);

}
