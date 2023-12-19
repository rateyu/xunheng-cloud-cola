package com.xunheng.member.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.client.dto.query.MemberPageQuery;
import com.xunheng.member.client.dto.MemberCreateCmd;
import com.xunheng.member.client.dto.MemberUpdateCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息service
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
public interface MemberService{

    /**
     * 会员信息分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<MemberVO> pageList(MemberPageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 会员信息id
     * @return 会员信息信息
     */
    MemberVO getDetail(String id);

    /**
     * 创建会员信息信息
     * @param cmd 创建操作cmd
     * @return 会员信息信息
     */
    MemberVO create(MemberCreateCmd cmd);

    /**
     * 更新会员信息信息
     * @param cmd 更新操作cmd
     * @return 会员信息信息
     */
    MemberVO update(MemberUpdateCmd cmd);

    /**
     * 根据id删除会员信息
     * @param id 会员信息id
     */
    void remove(String id);

}