package com.xunheng.wechat.app.assembler;

import com.xunheng.base.utils.EnumUtil;
import com.xunheng.wechat.client.dto.WechatAccountCreateCmd;
import com.xunheng.wechat.client.dto.WechatAccountUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.domain.wechatAccount.model.AccountType;
import com.xunheng.wechat.domain.wechatAccount.model.WechatAccountEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号dto转换
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public class WechatAccountAssembler {

    public static WechatAccountEntity toCreateEntity(WechatAccountCreateCmd cmd) {
        if(cmd == null)return null;
        WechatAccountEntity entity = new WechatAccountEntity();
        entity.setAppId(cmd.getAppId());
        entity.setName(cmd.getName());
        entity.setAppSecret(cmd.getAppSecret());
        entity.setToken(cmd.getToken());
        entity.setAesKey(cmd.getAesKey());
        entity.setType(EnumUtil.getMyEnum(AccountType.class, cmd.getType()));
        return entity;
    }

    public static WechatAccountEntity toUpdateEntity(WechatAccountUpdateCmd cmd) {
        if(cmd == null)return null;
        WechatAccountEntity entity = new WechatAccountEntity();
        entity.setId(cmd.getId());
        entity.setAppId(cmd.getAppId());
        entity.setName(cmd.getName());
        entity.setAppSecret(cmd.getAppSecret());
        entity.setToken(cmd.getToken());
        entity.setAesKey(cmd.getAesKey());
        entity.setType(EnumUtil.getMyEnum(AccountType.class, cmd.getType()));
        return entity;
    }

    public static WechatAccountVO toVo(WechatAccountEntity entity) {
        if(entity == null)return null;
        WechatAccountVO vo = new WechatAccountVO();
        vo.setId(entity.getId());
        vo.setAppId(entity.getAppId());
        vo.setName(entity.getName());
        vo.setAppSecret(entity.getAppSecret());
        vo.setToken(entity.getToken());
        vo.setAesKey(entity.getAesKey());
        vo.setType(entity.getType().getVal());
        return vo;
    }
}
