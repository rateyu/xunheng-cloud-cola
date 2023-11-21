package com.xunheng.member.infrastructure.convertor;

import com.xunheng.member.infrastructure.DO.Member;
import com.xunheng.member.domain.member.model.MemberEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息dto转换
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
public class MemberConvertor {

    public static Member toDO(MemberEntity entity) {
        if(entity == null)return null;
        Member member = new Member();
        member.setId(entity.getId());
        member.setName(entity.getName());
        member.setMobile(entity.getMobile());
        member.setSex(entity.getSex());
        member.setBirth(entity.getBirth());
        member.setAvatar(entity.getAvatar());
        member.setLevel(entity.getLevel());
        member.setOpenid(entity.getOpenid());
        member.setUnionid(entity.getUnionid());
        member.setAppId(entity.getAppId());
        return member;
    }

    public static MemberEntity toEntity(Member db) {
        if(db == null)return null;
        MemberEntity entity = new MemberEntity();
        entity.setId(db.getId());
        entity.setName(db.getName());
        entity.setMobile(db.getMobile());
        entity.setSex(db.getSex());
        entity.setBirth(db.getBirth());
        entity.setAvatar(db.getAvatar());
        entity.setLevel(db.getLevel());
        entity.setOpenid(db.getOpenid());
        entity.setUnionid(db.getUnionid());
        entity.setAppId(db.getAppId());
        return entity;
    }
}
