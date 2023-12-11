package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.base.utils.EnumUtil;
import com.xunheng.wechat.domain.account.model.AccountType;
import com.xunheng.wechat.infrastructure.DO.WechatAccount;
import com.xunheng.wechat.domain.account.model.WechatAccountEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号dto转换
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public class WechatAccountConvertor {

    public static WechatAccount toDO(WechatAccountEntity entity) {
        if(entity == null)return null;
        WechatAccount wechatAccount = new WechatAccount();
        wechatAccount.setId(entity.getId());
        wechatAccount.setAppId(entity.getAppId());
        wechatAccount.setName(entity.getName());
        wechatAccount.setAppSecret(entity.getAppSecret());
        wechatAccount.setToken(entity.getToken());
        wechatAccount.setAesKey(entity.getAesKey());
        wechatAccount.setType(entity.getType().getVal());
        return wechatAccount;
    }

    public static WechatAccountEntity toEntity(WechatAccount db) {
        if(db == null)return null;
        WechatAccountEntity entity = new WechatAccountEntity();
        entity.setId(db.getId());
        entity.setAppId(db.getAppId());
        entity.setName(db.getName());
        entity.setAppSecret(db.getAppSecret());
        entity.setToken(db.getToken());
        entity.setAesKey(db.getAesKey());
        entity.setType(EnumUtil.getMyEnum(AccountType.class, db.getType()));
        return entity;
    }
}
