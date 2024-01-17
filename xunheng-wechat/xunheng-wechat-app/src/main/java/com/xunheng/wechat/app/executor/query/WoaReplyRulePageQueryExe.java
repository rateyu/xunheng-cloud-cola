package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.app.assembler.WoaReplyRuleAssembler;
import com.xunheng.wechat.client.dto.query.WoaReplyRulePageQuery;
import com.xunheng.wechat.client.dto.VO.WoaReplyRuleVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaReplyRuleGateway;
import com.xunheng.wechat.domain.customerService.model.WoaReplyRuleEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则分页查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Component
public class WoaReplyRulePageQueryExe {

    @Resource
    WoaReplyRuleGateway woaReplyRuleGateway;

    public IPage<WoaReplyRuleVO> execute(WoaReplyRulePageQuery query) {
        if(StringUtils.isEmpty(query.getAppId())) return new Page<>();
        IPage<WoaReplyRuleEntity> page = woaReplyRuleGateway.pageList(query);
        return page.convert(WoaReplyRuleAssembler::toVo);
    }
}
