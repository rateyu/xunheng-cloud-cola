package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.WoaMsgTemplateCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgTemplateUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgTemplateEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
public class WoaMsgTemplateAssembler {

    public static WoaMsgTemplateEntity toCreateEntity(WoaMsgTemplateCreateCmd cmd) {
        if(cmd == null)return null;
        WoaMsgTemplateEntity entity = new WoaMsgTemplateEntity();
        entity.setAppId(cmd.getAppId());
        entity.setTemplateId(cmd.getTemplateId());
        entity.setName(cmd.getName());
        entity.setTitle(cmd.getTitle());
        entity.setContent(cmd.getContent());
        entity.setData(cmd.getData());
        entity.setUrl(cmd.getUrl());
        entity.setMiniProgram(cmd.getMiniProgram());
        entity.setStatus(cmd.getStatus());
        return entity;
    }

    public static WoaMsgTemplateEntity toUpdateEntity(WoaMsgTemplateUpdateCmd cmd) {
        if(cmd == null)return null;
        WoaMsgTemplateEntity entity = new WoaMsgTemplateEntity();
        entity.setId(cmd.getId());
        entity.setAppId(cmd.getAppId());
        entity.setTemplateId(cmd.getTemplateId());
        entity.setName(cmd.getName());
        entity.setTitle(cmd.getTitle());
        entity.setContent(cmd.getContent());
        entity.setData(cmd.getData());
        entity.setUrl(cmd.getUrl());
        entity.setMiniProgram(cmd.getMiniProgram());
        entity.setStatus(cmd.getStatus());
        return entity;
    }

    public static WoaMsgTemplateVO toVo(WoaMsgTemplateEntity entity) {
        if(entity == null)return null;
        WoaMsgTemplateVO vo = new WoaMsgTemplateVO();
        vo.setId(entity.getId());
        vo.setAppId(entity.getAppId());
        vo.setTemplateId(entity.getTemplateId());
        vo.setName(entity.getName());
        vo.setTitle(entity.getTitle());
        vo.setContent(entity.getContent());
        vo.setData(entity.getData());
        vo.setUrl(entity.getUrl());
        vo.setMiniProgram(entity.getMiniProgram());
        vo.setStatus(entity.getStatus());
        return vo;
    }
}
