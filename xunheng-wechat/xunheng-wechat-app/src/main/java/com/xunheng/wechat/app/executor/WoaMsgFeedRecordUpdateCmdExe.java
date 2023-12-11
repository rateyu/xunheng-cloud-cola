package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaMsgFeedRecordAssembler;
import com.xunheng.wechat.client.dto.WoaMsgFeedRecordUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgFeedRecordVO;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgFeedRecordGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志更新处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Component
public class WoaMsgFeedRecordUpdateCmdExe {

    @Resource
    private WoaMsgFeedRecordGateway woaMsgFeedRecordGateway;

    public WoaMsgFeedRecordVO execute(WoaMsgFeedRecordUpdateCmd cmd) {
        return WoaMsgFeedRecordAssembler.toVo(woaMsgFeedRecordGateway.update(WoaMsgFeedRecordAssembler.toUpdateEntity(cmd)));
    }

}
