package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WoaMsgAssembler;
import com.xunheng.wechat.client.dto.VO.WoaMsgVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Component
public class WoaMsgDetailQueryExe {
    @Resource
    WoaMsgGateway woaMsgGateway;

    public WoaMsgVO execute(String id) {
        return WoaMsgAssembler.toVo(woaMsgGateway.getOneById(id));
    }
}

