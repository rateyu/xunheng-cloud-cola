package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.api.WoaReplyRuleService;
import com.xunheng.wechat.client.dto.query.WoaReplyRulePageQuery;
import com.xunheng.wechat.client.dto.WoaReplyRuleCreateCmd;
import com.xunheng.wechat.client.dto.WoaReplyRuleUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.app.executor.WoaReplyRuleRemoveCmdExe;
import com.xunheng.wechat.app.executor.WoaReplyRuleCreateCmdExe;
import com.xunheng.wechat.app.executor.WoaReplyRuleUpdateCmdExe;
import com.xunheng.wechat.app.executor.query.WoaReplyRulePageQueryExe;
import com.xunheng.wechat.app.executor.query.WoaReplyRuleDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则service实现类
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Service
@GlobalTransactional
public class WoaReplyRuleServiceImpl implements WoaReplyRuleService {

    @Resource
    private WoaReplyRulePageQueryExe woaReplyRulePageQueryExe;

    @Resource
    private WoaReplyRuleDetailQueryExe woaReplyRuleDetailQueryExe;

    @Resource
    private WoaReplyRuleCreateCmdExe woaReplyRuleCreateCmdExe;
    
    @Resource
    private WoaReplyRuleUpdateCmdExe woaReplyRuleUpdateCmdExe;

    @Resource
    private WoaReplyRuleRemoveCmdExe woaReplyRuleRemoveCmdExe;

    @Override
    public IPage<WoaReplyRuleVO> pageList(WoaReplyRulePageQuery query){
        return woaReplyRulePageQueryExe.execute(query);
    }

    @Override
    public WoaReplyRuleVO getDetail(String id) {
        return woaReplyRuleDetailQueryExe.execute(id);
    }

    @Override
    public WoaReplyRuleVO create(WoaReplyRuleCreateCmd cmd) {
        return woaReplyRuleCreateCmdExe.execute(cmd);
    }

    @Override
    public WoaReplyRuleVO update(WoaReplyRuleUpdateCmd cmd) {
        return woaReplyRuleUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        woaReplyRuleRemoveCmdExe.execute(id);
    }

}