package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.Notice;
import com.xunheng.system.domain.notice.model.NoticeEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息通知DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class NoticeConvertor {
    public static Notice toDO(NoticeEntity entity) {
        Notice db = new Notice();
        db.setId(entity.getId());
        db.setTitle(entity.getTitle());
        db.setDescription(entity.getDescription());
        db.setContent(entity.getContent());
        db.setIsPub(entity.getIsPub());
        db.setUserId(entity.getUserId());
        db.setType(entity.getType());
        return db;
    }

    public static NoticeEntity toEntity(Notice db) {
        if(db == null)return null;
        NoticeEntity entity = new NoticeEntity();
        entity.setId(db.getId());
        entity.setTitle(db.getTitle());
        entity.setDescription(db.getDescription());
        entity.setContent(db.getContent());
        entity.setIsPub(db.getIsPub());
        entity.setUserId(db.getUserId());
        entity.setType(db.getType());
        entity.setTimeStr(db.getTimeStr());
        entity.setReadFlag(db.getReadFlag());
        return entity;
    }
}
