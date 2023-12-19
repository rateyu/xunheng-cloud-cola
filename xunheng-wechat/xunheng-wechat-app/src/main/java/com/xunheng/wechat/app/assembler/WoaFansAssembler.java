package com.xunheng.wechat.app.assembler;

import com.xunheng.wechat.client.dto.VO.WoaFansVO;
import com.xunheng.wechat.domain.fans.model.WoaFansEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝dto转换
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
public class WoaFansAssembler {


    public static WoaFansVO toVo(WoaFansEntity entity) {
        if(entity == null)return null;
        WoaFansVO vo = new WoaFansVO();
        vo.setId(entity.getId());
        vo.setOpenId(entity.getOpenId());
        vo.setAppId(entity.getAppId());
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
