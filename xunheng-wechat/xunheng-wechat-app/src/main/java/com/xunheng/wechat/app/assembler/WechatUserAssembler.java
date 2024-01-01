package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.VO.WechatUserVO;
import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户dto转换
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public class WechatUserAssembler {


    public static WechatUserVO toVo(WechatUserEntity entity) {
        if(entity == null)return null;
        WechatUserVO vo = new WechatUserVO();
        vo.setId(entity.getId());
        vo.setOpenId(entity.getOpenId());
        vo.setAppId(entity.getAppId());
        vo.setType(entity.getType());
        vo.setPhone(entity.getPhone());
        vo.setNickName(entity.getNickName());
        vo.setSex(entity.getSex());
        vo.setCity(entity.getCity());
        vo.setProvince(entity.getProvince());
        vo.setHeadImgUrl(entity.getHeadImgUrl());
        vo.setSubscribeTime(entity.getSubscribeTime());
        vo.setSubscribe(entity.getSubscribe());
        vo.setUnionId(entity.getUnionId());
        vo.setRemark(entity.getRemark());
        vo.setTagIdList(entity.getTagIdList());
        vo.setSubscribeScene(entity.getSubscribeScene());
        vo.setQrSceneStr(entity.getQrSceneStr());
        return vo;
    }
}
