package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WoaMsgFeedRecordAssembler;
import com.xunheng.wechat.client.dto.VO.WoaMsgFeedRecordVO;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgFeedRecordGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Component
public class WoaMsgFeedRecordDetailQueryExe {
    @Resource
    WoaMsgFeedRecordGateway woaMsgFeedRecordGateway;

    public WoaMsgFeedRecordVO execute(String id) {
        return WoaMsgFeedRecordAssembler.toVo(woaMsgFeedRecordGateway.getOneById(id));
    }
}

