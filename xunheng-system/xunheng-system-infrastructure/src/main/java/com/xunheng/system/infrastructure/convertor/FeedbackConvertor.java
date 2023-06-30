package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.Feedback;
import com.xunheng.system.domain.Feedback.model.FeedbackEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 意见反馈DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class FeedbackConvertor {
    public static Feedback toDO(FeedbackEntity entity) {
        Feedback db = new Feedback();
        db.setId(entity.getId());
        db.setContent(entity.getContent());
        return db;
    }

    public static FeedbackEntity toEntity(Feedback db) {
        if(db == null)return null;
        FeedbackEntity entity = new FeedbackEntity();
        entity.setId(db.getId());
        entity.setContent(db.getContent());
        return entity;
    }
}
