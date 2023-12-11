package com.xunheng.wechat.domain.account.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.domain.account.model.WechatAccountEntity;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: WechatAccount网关
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public interface WechatAccountGateway {

    /**
     * 微信开发帐号分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WechatAccountEntity> pageList(WechatAccountPageQuery query);

    /**
     * 获取所有微信开发帐号
     * @return 微信开发帐号列表
     */
    List<WechatAccountEntity> allList();

    /**
     * 根据id获取微信开发帐号信息
     * @param id 微信开发帐号id
     * @return 微信开发帐号实体
     */
    WechatAccountEntity getOneById(String id);

    /**
     * 保存或更新微信开发帐号实体
     * @param entity 微信开发帐号实体
     * @return 微信开发帐号实体
     */
    WechatAccountEntity saveOrUpdate(WechatAccountEntity entity);

    /**
     * 创建微信开发帐号实体
     * @param entity 微信开发帐号实体
     * @return 微信开发帐号实体
     */
    WechatAccountEntity create(WechatAccountEntity entity);

    /**
     * 更新微信开发帐号实体
     * @param entity 微信开发帐号实体
     * @return 微信开发帐号实体
     */
    WechatAccountEntity update(WechatAccountEntity entity);

    /**
     * 根据id删除微信开发帐号
     * @param id 微信开发帐号id
     */
    void remove(String id);

}
