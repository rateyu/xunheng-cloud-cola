package com.xunheng.member.app.executor;

import com.xunheng.member.app.assembler.MemberAssembler;
import com.xunheng.member.client.dto.MemberCreateCmd;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.domain.member.gateway.MemberGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息创建处理器
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Component
public class MemberCreateCmdExe {

    @Resource
    private MemberGateway memberGateway;

    public MemberVO execute(MemberCreateCmd cmd) {
        return MemberAssembler.toVo(memberGateway.create(MemberAssembler.toCreateEntity(cmd)));
    }

}
