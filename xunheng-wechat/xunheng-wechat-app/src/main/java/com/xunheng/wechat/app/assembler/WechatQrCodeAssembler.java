package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.WechatQrCodeCreateCmd;
import com.xunheng.wechat.client.dto.WechatQrCodeUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.domain.account.model.WechatQrCodeEntity;

import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
public class WechatQrCodeAssembler {

    public static WechatQrCodeEntity toCreateEntity(WechatQrCodeCreateCmd cmd) {
        if(cmd == null)return null;
        WechatQrCodeEntity entity = new WechatQrCodeEntity();
        entity.setAppId(cmd.getAppId());
        entity.setType(cmd.getType());
        entity.setSceneStr(cmd.getSceneStr());
        entity.setTicket(cmd.getTicket());
        entity.setUrl(cmd.getUrl());
       // entity.setExpireTime(new Date(System.currentTimeMillis() + ticket.getExpireSeconds() * 1000L));
        return entity;
    }

    public static WechatQrCodeEntity toUpdateEntity(WechatQrCodeUpdateCmd cmd) {
        if(cmd == null)return null;
        WechatQrCodeEntity entity = new WechatQrCodeEntity();
        entity.setId(cmd.getId());
        entity.setAppId(cmd.getAppId());
        entity.setType(cmd.getType());
        entity.setSceneStr(cmd.getSceneStr());
        entity.setTicket(cmd.getTicket());
        entity.setUrl(cmd.getUrl());
       // entity.setExpireTime(cmd.getExpireTime());
        return entity;
    }

    public static WechatQrCodeVO toVo(WechatQrCodeEntity entity) {
        if(entity == null)return null;
        WechatQrCodeVO vo = new WechatQrCodeVO();
        vo.setId(entity.getId());
        vo.setAppId(entity.getAppId());
        vo.setType(entity.getType());
        vo.setSceneStr(entity.getSceneStr());
        vo.setTicket(entity.getTicket());
        vo.setUrl(entity.getUrl());
        vo.setExpireTime(entity.getExpireTime());
        return vo;
    }
}
