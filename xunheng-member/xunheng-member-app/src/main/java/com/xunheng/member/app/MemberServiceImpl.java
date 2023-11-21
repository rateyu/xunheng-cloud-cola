package com.xunheng.member.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.member.client.api.MemberService;
import com.xunheng.member.client.dto.query.MemberPageQuery;
import com.xunheng.member.client.dto.MemberCreateCmd;
import com.xunheng.member.client.dto.MemberUpdateCmd;
import com.xunheng.member.client.dto.VO.MemberVO;
import com.xunheng.member.app.executor.MemberRemoveCmdExe;
import com.xunheng.member.app.executor.MemberCreateCmdExe;
import com.xunheng.member.app.executor.MemberUpdateCmdExe;
import com.xunheng.member.app.executor.query.MemberPageQueryExe;
import com.xunheng.member.app.executor.query.MemberDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 会员信息service实现类
 * @author: hhqkkr
 * @date: 2023/11/12 12:01:00
 */
@Service
@GlobalTransactional
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberPageQueryExe memberPageQueryExe;

    @Resource
    private MemberDetailQueryExe memberDetailQueryExe;

    @Resource
    private MemberCreateCmdExe memberCreateCmdExe;
    
    @Resource
    private MemberUpdateCmdExe memberUpdateCmdExe;

    @Resource
    private MemberRemoveCmdExe memberRemoveCmdExe;

    @Override
    public IPage<MemberVO> pageList(MemberPageQuery query){
        return memberPageQueryExe.execute(query);
    }

    @Override
    public MemberVO getDetail(String id) {
        return memberDetailQueryExe.execute(id);
    }

    @Override
    public MemberVO create(MemberCreateCmd cmd) {
        return memberCreateCmdExe.execute(cmd);
    }

    @Override
    public MemberVO update(MemberUpdateCmd cmd) {
        return memberUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        memberRemoveCmdExe.execute(id);
    }

}