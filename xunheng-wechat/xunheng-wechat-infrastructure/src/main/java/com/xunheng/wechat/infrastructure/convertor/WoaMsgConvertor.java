package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WoaMsg;
import com.xunheng.wechat.domain.customerService.model.WoaMsgEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
public class WoaMsgConvertor {

    public static WoaMsg toDO(WoaMsgEntity entity) {
        if(entity == null)return null;
        WoaMsg woaMsg = new WoaMsg();
        woaMsg.setId(entity.getId());
        woaMsg.setAppId(entity.getAppId());
        woaMsg.setOpenId(entity.getOpenId());
        woaMsg.setInOut(entity.getInOut());
        woaMsg.setMsgType(entity.getMsgType());
        woaMsg.setDetail(entity.getDetail());
        return woaMsg;
    }

    public static WoaMsgEntity toEntity(WoaMsg db) {
        if(db == null)return null;
        WoaMsgEntity entity = new WoaMsgEntity();
        entity.setId(db.getId());
        entity.setAppId(db.getAppId());
        entity.setOpenId(db.getOpenId());
        entity.setInOut(db.getInOut());
        entity.setMsgType(db.getMsgType());
        entity.setDetail(db.getDetail());
        return entity;
    }
}
