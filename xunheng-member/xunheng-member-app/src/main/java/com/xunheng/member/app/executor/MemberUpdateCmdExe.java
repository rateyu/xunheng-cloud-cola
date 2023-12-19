package com.xunheng.member.app.executor;

import com.xunheng.member.app.assembler.MemberAssembler;
import com.xunheng.member.client.dto.MemberUpdateCmd;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.domain.member.gateway.MemberGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息更新处理器
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Component
public class MemberUpdateCmdExe {

    @Resource
    private MemberGateway memberGateway;

    public MemberVO execute(MemberUpdateCmd cmd) {
        return MemberAssembler.toVo(memberGateway.update(MemberAssembler.toUpdateEntity(cmd)));
    }

}
