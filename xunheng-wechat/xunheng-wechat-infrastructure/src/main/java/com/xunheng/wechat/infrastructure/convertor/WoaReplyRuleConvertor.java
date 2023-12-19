package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WoaReplyRule;
import com.xunheng.wechat.domain.customerService.model.WoaReplyRuleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
public class WoaReplyRuleConvertor {

    public static WoaReplyRule toDO(WoaReplyRuleEntity entity) {
        if(entity == null)return null;
        WoaReplyRule woaReplyRule = new WoaReplyRule();
        woaReplyRule.setId(entity.getId());
        woaReplyRule.setAppId(entity.getAppId());
        woaReplyRule.setRuleName(entity.getRuleName());
        woaReplyRule.setMatchValue(entity.getMatchValue());
        woaReplyRule.setExactMatch(entity.getExactMatch());
        woaReplyRule.setReplyType(entity.getReplyType());
        woaReplyRule.setReplyContent(entity.getReplyContent());
        woaReplyRule.setStatus(entity.getStatus());
        woaReplyRule.setStartTime(entity.getStartTime());
        woaReplyRule.setEndTime(entity.getEndTime());
        woaReplyRule.setPriority(entity.getPriority());
        return woaReplyRule;
    }

    public static WoaReplyRuleEntity toEntity(WoaReplyRule db) {
        if(db == null)return null;
        WoaReplyRuleEntity entity = new WoaReplyRuleEntity();
        entity.setId(db.getId());
        entity.setAppId(db.getAppId());
        entity.setRuleName(db.getRuleName());
        entity.setMatchValue(db.getMatchValue());
        entity.setExactMatch(db.getExactMatch());
        entity.setReplyType(db.getReplyType());
        entity.setReplyContent(db.getReplyContent());
        entity.setStatus(db.getStatus());
        entity.setStartTime(db.getStartTime());
        entity.setEndTime(db.getEndTime());
        entity.setPriority(db.getPriority());
        return entity;
    }
}
