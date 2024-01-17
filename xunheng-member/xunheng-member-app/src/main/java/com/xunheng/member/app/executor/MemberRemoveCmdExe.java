package com.xunheng.member.app.executor;

import com.xunheng.member.domain.member.gateway.MemberGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息删除操作处理器
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Component
public class MemberRemoveCmdExe {

    @Resource
    private MemberGateway memberGateway;

    public void execute(String id) {
        memberGateway.remove(id);
    }

}
