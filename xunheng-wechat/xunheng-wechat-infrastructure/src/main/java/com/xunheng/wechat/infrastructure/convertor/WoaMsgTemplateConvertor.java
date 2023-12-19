package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WoaMsgTemplate;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgTemplateEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
public class WoaMsgTemplateConvertor {

    public static WoaMsgTemplate toDO(WoaMsgTemplateEntity entity) {
        if(entity == null)return null;
        WoaMsgTemplate woaMsgTemplate = new WoaMsgTemplate();
        woaMsgTemplate.setId(entity.getId());
        woaMsgTemplate.setAppId(entity.getAppId());
        woaMsgTemplate.setTemplateId(entity.getTemplateId());
        woaMsgTemplate.setName(entity.getName());
        woaMsgTemplate.setTitle(entity.getTitle());
        woaMsgTemplate.setContent(entity.getContent());
        woaMsgTemplate.setData(entity.getData());
        woaMsgTemplate.setUrl(entity.getUrl());
        woaMsgTemplate.setMiniProgram(entity.getMiniProgram());
        woaMsgTemplate.setStatus(entity.getStatus());
        return woaMsgTemplate;
    }

    public static WoaMsgTemplateEntity toEntity(WoaMsgTemplate db) {
        if(db == null)return null;
        WoaMsgTemplateEntity entity = new WoaMsgTemplateEntity();
        entity.setId(db.getId());
        entity.setAppId(db.getAppId());
        entity.setTemplateId(db.getTemplateId());
        entity.setName(db.getName());
        entity.setTitle(db.getTitle());
        entity.setContent(db.getContent());
        entity.setData(db.getData());
        entity.setUrl(db.getUrl());
        entity.setMiniProgram(db.getMiniProgram());
        entity.setStatus(db.getStatus());
        return entity;
    }
}
