package com.xunheng.member.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.member.infrastructure.DO.Member;
import com.xunheng.member.infrastructure.convertor.MemberConvertor;
import com.xunheng.member.client.dto.query.MemberPageQuery;
import com.xunheng.member.domain.member.gateway.MemberGateway;
import com.xunheng.member.infrastructure.mapper.MemberMapper;
import com.xunheng.member.domain.member.model.MemberEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息网关实现类
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Slf4j
@Component
public class MemberGatewayImpl implements MemberGateway {

    @Resource
    MemberMapper memberMapper;

    @Override
    public IPage<MemberEntity> pageList(MemberPageQuery query) {
        IPage<Member> page = memberMapper.pageList(new Page<Member>(query.getPage(), query.getPageSize()), query);
        return page.convert(MemberConvertor::toEntity);
    }

    @Override
    public MemberEntity getOneById(String id) {
        Member member = memberMapper.selectById(id);
        return MemberConvertor.toEntity(member);
    }

    @Override
    public MemberEntity saveOrUpdate(MemberEntity entity) {
        Member member = MemberConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(member.getId()) ? memberMapper.insert(member) : memberMapper.updateById(member);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return MemberConvertor.toEntity(member);
    }

    @Override
    public MemberEntity create(MemberEntity entity) {
        Member member = MemberConvertor.toDO(entity);
        int count = memberMapper.insert(member);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return MemberConvertor.toEntity(member);
    }

    @Override
    public MemberEntity update(MemberEntity entity) {
        Member member = MemberConvertor.toDO(entity);
        int count = memberMapper.updateById(member);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return MemberConvertor.toEntity(member);
    }

    @Override
    public void remove(String id) {
        memberMapper.deleteById(id);
    }


}
