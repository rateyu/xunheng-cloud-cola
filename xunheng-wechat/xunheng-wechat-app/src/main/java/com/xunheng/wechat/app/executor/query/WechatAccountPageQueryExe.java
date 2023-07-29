package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.app.assembler.WechatAccountAssembler;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import com.xunheng.wechat.client.dto.VO.WechatAccountVO;
import com.xunheng.wechat.domain.wechatAccount.gateway.WechatAccountGateway;
import com.xunheng.wechat.domain.wechatAccount.model.WechatAccountEntity;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号分页查询处理器
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Component
public class WechatAccountPageQueryExe {

    @Resource
    WechatAccountGateway wechatAccountGateway;

    public IPage<WechatAccountVO> execute(WechatAccountPageQuery query) {
        IPage<WechatAccountEntity> page = wechatAccountGateway.pageList(query);
        return page.convert(WechatAccountAssembler::toVo);
    }
}
