package com.xunheng.member.app.executor.query;

import com.xunheng.member.app.assembler.MemberAssembler;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.domain.member.gateway.MemberGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Component
public class MemberDetailQueryExe {
    @Resource
    MemberGateway memberGateway;

    public MemberVO execute(String id) {
        return MemberAssembler.toVo(memberGateway.getOneById(id));
    }
}

