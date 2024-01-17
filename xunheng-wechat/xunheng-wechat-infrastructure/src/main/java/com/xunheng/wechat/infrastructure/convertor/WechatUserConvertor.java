package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WechatUser;
import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户dto转换
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public class WechatUserConvertor {

    public static WechatUser toDO(WechatUserEntity entity) {
        if(entity == null)return null;
        WechatUser wechatUser = new WechatUser();
        wechatUser.setId(entity.getId());
        wechatUser.setOpenId(entity.getOpenId());
        wechatUser.setAppId(entity.getAppId());
        wechatUser.setType(entity.getType());
        wechatUser.setPhone(entity.getPhone());
        wechatUser.setNickName(entity.getNickName());
        wechatUser.setSex(entity.getSex());
        wechatUser.setCity(entity.getCity());
        wechatUser.setProvince(entity.getProvince());
        wechatUser.setHeadImgUrl(entity.getHeadImgUrl());
        wechatUser.setSubscribeTime(entity.getSubscribeTime());
        wechatUser.setSubscribe(entity.getSubscribe());
        wechatUser.setUnionId(entity.getUnionId());
        wechatUser.setRemark(entity.getRemark());
        wechatUser.setTagIdList(entity.getTagIdList());
        wechatUser.setSubscribeScene(entity.getSubscribeScene());
        wechatUser.setQrSceneStr(entity.getQrSceneStr());
        return wechatUser;
    }

    public static WechatUserEntity toEntity(WechatUser db) {
        if(db == null)return null;
        WechatUserEntity entity = new WechatUserEntity();
        entity.setId(db.getId());
        entity.setOpenId(db.getOpenId());
        entity.setAppId(db.getAppId());
        entity.setType(db.getType());
        entity.setPhone(db.getPhone());
        entity.setNickName(db.getNickName());
        entity.setSex(db.getSex());
        entity.setCity(db.getCity());
        entity.setProvince(db.getProvince());
        entity.setHeadImgUrl(db.getHeadImgUrl());
        entity.setSubscribeTime(db.getSubscribeTime());
        entity.setSubscribe(db.getSubscribe());
        entity.setUnionId(db.getUnionId());
        entity.setRemark(db.getRemark());
        entity.setTagIdList(db.getTagIdList());
        entity.setSubscribeScene(db.getSubscribeScene());
        entity.setQrSceneStr(db.getQrSceneStr());
        return entity;
    }
}
