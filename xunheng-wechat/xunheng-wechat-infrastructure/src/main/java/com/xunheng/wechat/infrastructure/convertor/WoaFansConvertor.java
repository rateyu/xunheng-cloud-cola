package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WoaFans;
import com.xunheng.wechat.domain.fans.model.WoaFansEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝dto转换
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public class WoaFansConvertor {

    public static WoaFans toDO(WoaFansEntity entity) {
        if(entity == null)return null;
        WoaFans woaFans = new WoaFans();
        woaFans.setId(entity.getId());
        woaFans.setOpenId(entity.getOpenId());
        woaFans.setAppId(entity.getAppId());
        woaFans.setPhone(entity.getPhone());
        woaFans.setNickName(entity.getNickName());
        woaFans.setSex(entity.getSex());
        woaFans.setCity(entity.getCity());
        woaFans.setProvince(entity.getProvince());
        woaFans.setHeadImgUrl(entity.getHeadImgUrl());
        woaFans.setSubscribeTime(entity.getSubscribeTime());
        woaFans.setSubscribe(entity.getSubscribe());
        woaFans.setUnionId(entity.getUnionId());
        woaFans.setRemark(entity.getRemark());
        woaFans.setTagIdList(entity.getTagIdList());
        woaFans.setSubscribeScene(entity.getSubscribeScene());
        woaFans.setQrSceneStr(entity.getQrSceneStr());
        return woaFans;
    }

    public static WoaFansEntity toEntity(WoaFans db) {
        if(db == null)return null;
        WoaFansEntity entity = new WoaFansEntity();
        entity.setId(db.getId());
        entity.setOpenId(db.getOpenId());
        entity.setAppId(db.getAppId());
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
