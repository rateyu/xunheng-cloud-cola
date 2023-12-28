package com.xunheng.member.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.member.app.assembler.MemberAssembler;
import com.xunheng.member.client.dto.query.MemberPageQuery;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.domain.member.gateway.MemberGateway;
import com.xunheng.member.domain.member.model.MemberEntity;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Component
public class MemberPageQueryExe {

    @Resource
    MemberGateway memberGateway;

    public IPage<MemberVO> execute(MemberPageQuery query) {
        IPage<MemberEntity> page = memberGateway.pageList(query);
        return page.convert(MemberAssembler::toVo);
    }
}
