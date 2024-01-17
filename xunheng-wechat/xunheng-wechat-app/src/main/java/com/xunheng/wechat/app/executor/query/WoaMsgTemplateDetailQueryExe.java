package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WoaMsgTemplateAssembler;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Component
public class WoaMsgTemplateDetailQueryExe {
    @Resource
    WoaMsgTemplateGateway woaMsgTemplateGateway;

    public WoaMsgTemplateVO execute(String id) {
        return WoaMsgTemplateAssembler.toVo(woaMsgTemplateGateway.getOneById(id));
    }
}

