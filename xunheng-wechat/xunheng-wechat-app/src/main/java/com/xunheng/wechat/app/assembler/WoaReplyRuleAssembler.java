package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.WoaReplyRuleCreateCmd;
import com.xunheng.wechat.client.dto.WoaReplyRuleUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.domain.customerService.model.WoaReplyRuleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
public class WoaReplyRuleAssembler {

    public static WoaReplyRuleEntity toCreateEntity(WoaReplyRuleCreateCmd cmd) {
        if(cmd == null)return null;
        WoaReplyRuleEntity entity = new WoaReplyRuleEntity();
        entity.setAppId(cmd.getAppId());
        entity.setRuleName(cmd.getRuleName());
        entity.setMatchValue(cmd.getMatchValue());
        entity.setExactMatch(cmd.getExactMatch());
        entity.setReplyType(cmd.getReplyType());
        entity.setReplyContent(cmd.getReplyContent());
        entity.setStatus(cmd.getStatus());
        entity.setStartTime(cmd.getStartTime());
        entity.setEndTime(cmd.getEndTime());
        entity.setPriority(cmd.getPriority());
        return entity;
    }

    public static WoaReplyRuleEntity toUpdateEntity(WoaReplyRuleUpdateCmd cmd) {
        if(cmd == null)return null;
        WoaReplyRuleEntity entity = new WoaReplyRuleEntity();
        entity.setId(cmd.getId());
        entity.setAppId(cmd.getAppId());
        entity.setRuleName(cmd.getRuleName());
        entity.setMatchValue(cmd.getMatchValue());
        entity.setExactMatch(cmd.getExactMatch());
        entity.setReplyType(cmd.getReplyType());
        entity.setReplyContent(cmd.getReplyContent());
        entity.setStatus(cmd.getStatus());
        entity.setStartTime(cmd.getStartTime());
        entity.setEndTime(cmd.getEndTime());
        entity.setPriority(cmd.getPriority());
        return entity;
    }

    public static WoaReplyRuleVO toVo(WoaReplyRuleEntity entity) {
        if(entity == null)return null;
        WoaReplyRuleVO vo = new WoaReplyRuleVO();
        vo.setId(entity.getId());
        vo.setAppId(entity.getAppId());
        vo.setRuleName(entity.getRuleName());
        vo.setMatchValue(entity.getMatchValue());
        vo.setExactMatch(entity.getExactMatch());
        vo.setReplyType(entity.getReplyType());
        vo.setReplyContent(entity.getReplyContent());
        vo.setStatus(entity.getStatus());
        vo.setStartTime(entity.getStartTime());
        vo.setEndTime(entity.getEndTime());
        vo.setPriority(entity.getPriority());
        return vo;
    }
}
