package com.xunheng.member.app.assembler;

import com.xunheng.member.client.dto.MemberCreateCmd;
import com.xunheng.member.client.dto.MemberUpdateCmd;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.domain.member.model.MemberEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息dto转换
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
public class MemberAssembler {

    public static MemberEntity toCreateEntity(MemberCreateCmd cmd) {
        if(cmd == null)return null;
        MemberEntity entity = new MemberEntity();
        entity.setName(cmd.getName());
        entity.setMobile(cmd.getMobile());
        entity.setSex(cmd.getSex());
        entity.setBirth(cmd.getBirth());
        entity.setAvatar(cmd.getAvatar());
        entity.setLevel(cmd.getLevel());
        entity.setOpenid(cmd.getOpenid());
        entity.setUnionid(cmd.getUnionid());
        entity.setAppId(cmd.getAppId());
        return entity;
    }

    public static MemberEntity toUpdateEntity(MemberUpdateCmd cmd) {
        if(cmd == null)return null;
        MemberEntity entity = new MemberEntity();
        entity.setId(cmd.getId());
        entity.setName(cmd.getName());
        entity.setMobile(cmd.getMobile());
        entity.setSex(cmd.getSex());
        entity.setBirth(cmd.getBirth());
        entity.setAvatar(cmd.getAvatar());
        entity.setLevel(cmd.getLevel());
        entity.setOpenid(cmd.getOpenid());
        entity.setUnionid(cmd.getUnionid());
        entity.setAppId(cmd.getAppId());
        return entity;
    }

    public static MemberVO toVo(MemberEntity entity) {
        if(entity == null)return null;
        MemberVO vo = new MemberVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setMobile(entity.getMobile());
        vo.setSex(entity.getSex());
        vo.setBirth(entity.getBirth());
        vo.setAvatar(entity.getAvatar());
        vo.setLevel(entity.getLevel());
        vo.setOpenid(entity.getOpenid());
        vo.setUnionid(entity.getUnionid());
        vo.setAppId(entity.getAppId());
        return vo;
    }
}
