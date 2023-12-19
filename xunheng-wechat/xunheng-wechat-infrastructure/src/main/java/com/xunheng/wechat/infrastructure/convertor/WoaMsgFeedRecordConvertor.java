package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WoaMsgFeedRecord;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgFeedRecordEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
public class WoaMsgFeedRecordConvertor {

    public static WoaMsgFeedRecord toDO(WoaMsgFeedRecordEntity entity) {
        if(entity == null)return null;
        WoaMsgFeedRecord woaMsgFeedRecord = new WoaMsgFeedRecord();
        woaMsgFeedRecord.setId(entity.getId());
        woaMsgFeedRecord.setAppId(entity.getAppId());
        woaMsgFeedRecord.setOpenId(entity.getOpenId());
        woaMsgFeedRecord.setTemplateId(entity.getTemplateId());
        woaMsgFeedRecord.setData(entity.getData());
        woaMsgFeedRecord.setUrl(entity.getUrl());
        woaMsgFeedRecord.setMiniProgram(entity.getMiniProgram());
        woaMsgFeedRecord.setFeedResult(entity.getFeedResult());
        return woaMsgFeedRecord;
    }

    public static WoaMsgFeedRecordEntity toEntity(WoaMsgFeedRecord db) {
        if(db == null)return null;
        WoaMsgFeedRecordEntity entity = new WoaMsgFeedRecordEntity();
        entity.setId(db.getId());
        entity.setAppId(db.getAppId());
        entity.setOpenId(db.getOpenId());
        entity.setTemplateId(db.getTemplateId());
        entity.setData(db.getData());
        entity.setUrl(db.getUrl());
        entity.setMiniProgram(db.getMiniProgram());
        entity.setFeedResult(db.getFeedResult());
        return entity;
    }
}
