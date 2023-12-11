package com.xunheng.wechat.domain.account.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.domain.account.model.WechatQrCodeEntity;
import com.xunheng.wechat.client.dto.query.WechatQrCodePageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: WechatQrCode网关
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
public interface WechatQrCodeGateway {

    /**
     * 账号二维码信息分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WechatQrCodeEntity> pageList(WechatQrCodePageQuery query);

    /**
     * 根据id获取账号二维码信息信息
     * @param id 账号二维码信息id
     * @return 账号二维码信息实体
     */
    WechatQrCodeEntity getOneById(String id);

    /**
     * 保存或更新账号二维码信息实体
     * @param entity 账号二维码信息实体
     * @return 账号二维码信息实体
     */
    WechatQrCodeEntity saveOrUpdate(WechatQrCodeEntity entity);

    /**
     * 创建账号二维码信息实体
     * @param entity 账号二维码信息实体
     * @return 账号二维码信息实体
     */
    WechatQrCodeEntity create(WechatQrCodeEntity entity);

    /**
     * 更新账号二维码信息实体
     * @param entity 账号二维码信息实体
     * @return 账号二维码信息实体
     */
    WechatQrCodeEntity update(WechatQrCodeEntity entity);

    /**
     * 根据id删除账号二维码信息
     * @param id 账号二维码信息id
     */
    void remove(String id);

}
