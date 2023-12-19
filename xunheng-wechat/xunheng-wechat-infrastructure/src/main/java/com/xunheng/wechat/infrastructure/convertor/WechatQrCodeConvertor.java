package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WechatQrCode;
import com.xunheng.wechat.domain.account.model.WechatQrCodeEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
public class WechatQrCodeConvertor {

    public static WechatQrCode toDO(WechatQrCodeEntity entity) {
        if(entity == null)return null;
        WechatQrCode wechatQrCode = new WechatQrCode();
        wechatQrCode.setId(entity.getId());
        wechatQrCode.setAppId(entity.getAppId());
        wechatQrCode.setType(entity.getType());
        wechatQrCode.setSceneStr(entity.getSceneStr());
        wechatQrCode.setTicket(entity.getTicket());
        wechatQrCode.setUrl(entity.getUrl());
        wechatQrCode.setExpireTime(entity.getExpireTime());
        return wechatQrCode;
    }

    public static WechatQrCodeEntity toEntity(WechatQrCode db) {
        if(db == null)return null;
        WechatQrCodeEntity entity = new WechatQrCodeEntity();
        entity.setId(db.getId());
        entity.setAppId(db.getAppId());
        entity.setType(db.getType());
        entity.setSceneStr(db.getSceneStr());
        entity.setTicket(db.getTicket());
        entity.setUrl(db.getUrl());
        entity.setExpireTime(db.getExpireTime());
        return entity;
    }
}
