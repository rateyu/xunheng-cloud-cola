package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.WoaMsgCreateCmd;
import com.xunheng.wechat.client.dto.WoaMsgUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgVO;
import com.xunheng.wechat.domain.customerService.model.WoaMsgEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息dto转换
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
public class WoaMsgAssembler {

    public static WoaMsgEntity toCreateEntity(WoaMsgCreateCmd cmd) {
        if(cmd == null)return null;
        WoaMsgEntity entity = new WoaMsgEntity();
        entity.setAppId(cmd.getAppId());
        entity.setOpenId(cmd.getOpenId());
        entity.setInOut(cmd.getInOut());
        entity.setMsgType(cmd.getMsgType());
        entity.setDetail(cmd.getDetail());
        return entity;
    }

    public static WoaMsgEntity toUpdateEntity(WoaMsgUpdateCmd cmd) {
        if(cmd == null)return null;
        WoaMsgEntity entity = new WoaMsgEntity();
        entity.setId(cmd.getId());
        entity.setAppId(cmd.getAppId());
        entity.setOpenId(cmd.getOpenId());
        entity.setInOut(cmd.getInOut());
        entity.setMsgType(cmd.getMsgType());
        entity.setDetail(cmd.getDetail());
        return entity;
    }

    public static WoaMsgVO toVo(WoaMsgEntity entity) {
        if(entity == null)return null;
        WoaMsgVO vo = new WoaMsgVO();
        vo.setId(entity.getId());
        vo.setAppId(entity.getAppId());
        vo.setOpenId(entity.getOpenId());
        vo.setInOut(entity.getInOut());
        vo.setMsgType(entity.getMsgType());
        vo.setDetail(entity.getDetail());
        return vo;
    }
}
