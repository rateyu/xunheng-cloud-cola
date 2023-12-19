package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.WoaMsgFeedRecordCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgFeedRecordVO;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgFeedRecordEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
public class WoaMsgFeedRecordAssembler {

    public static WoaMsgFeedRecordEntity toCreateEntity(WoaMsgFeedRecordCreateCmd cmd) {
        if(cmd == null)return null;
        WoaMsgFeedRecordEntity entity = new WoaMsgFeedRecordEntity();
        entity.setAppId(cmd.getAppId());
        entity.setOpenId(cmd.getOpenId());
        entity.setTemplateId(cmd.getTemplateId());
        entity.setData(cmd.getData());
        entity.setUrl(cmd.getUrl());
        entity.setMiniProgram(cmd.getMiniProgram());
        entity.setFeedResult(cmd.getFeedResult());
        return entity;
    }

    public static WoaMsgFeedRecordEntity toUpdateEntity(WoaMsgFeedRecordUpdateCmd cmd) {
        if(cmd == null)return null;
        WoaMsgFeedRecordEntity entity = new WoaMsgFeedRecordEntity();
        entity.setId(cmd.getId());
        entity.setAppId(cmd.getAppId());
        entity.setOpenId(cmd.getOpenId());
        entity.setTemplateId(cmd.getTemplateId());
        entity.setData(cmd.getData());
        entity.setUrl(cmd.getUrl());
        entity.setMiniProgram(cmd.getMiniProgram());
        entity.setFeedResult(cmd.getFeedResult());
        return entity;
    }

    public static WoaMsgFeedRecordVO toVo(WoaMsgFeedRecordEntity entity) {
        if(entity == null)return null;
        WoaMsgFeedRecordVO vo = new WoaMsgFeedRecordVO();
        vo.setId(entity.getId());
        vo.setAppId(entity.getAppId());
        vo.setOpenId(entity.getOpenId());
        vo.setTemplateId(entity.getTemplateId());
        vo.setData(entity.getData());
        vo.setUrl(entity.getUrl());
        vo.setMiniProgram(entity.getMiniProgram());
        vo.setFeedResult(entity.getFeedResult());
        return vo;
    }
}
