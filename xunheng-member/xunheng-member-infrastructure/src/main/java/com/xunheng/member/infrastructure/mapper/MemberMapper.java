package com.xunheng.member.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.member.infrastructure.DO.Member;
import com.xunheng.member.client.dto.query.MemberPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息数据层
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Repository
public interface MemberMapper extends BaseMapper<Member> {

    /**
     * 获取会员信息分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<Member> pageList(Page<Member> page, @Param("qry") MemberPageQuery query);

}
