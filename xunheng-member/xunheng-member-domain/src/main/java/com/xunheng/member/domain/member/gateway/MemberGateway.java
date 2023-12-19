package com.xunheng.member.domain.member.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.member.domain.member.model.MemberEntity;
import com.xunheng.member.client.dto.query.MemberPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: Member网关
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
public interface MemberGateway {

    /**
     * 会员信息分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<MemberEntity> pageList(MemberPageQuery query);

    /**
     * 根据id获取会员信息信息
     * @param id 会员信息id
     * @return 会员信息实体
     */
    MemberEntity getOneById(String id);

    /**
     * 保存或更新会员信息实体
     * @param entity 会员信息实体
     * @return 会员信息实体
     */
    MemberEntity saveOrUpdate(MemberEntity entity);

    /**
     * 创建会员信息实体
     * @param entity 会员信息实体
     * @return 会员信息实体
     */
    MemberEntity create(MemberEntity entity);

    /**
     * 更新会员信息实体
     * @param entity 会员信息实体
     * @return 会员信息实体
     */
    MemberEntity update(MemberEntity entity);

    /**
     * 根据id删除会员信息
     * @param id 会员信息id
     */
    void remove(String id);

}
