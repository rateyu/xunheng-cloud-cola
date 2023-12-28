package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaMsgTemplateAssembler;
import com.xunheng.wechat.client.dto.WoaMsgTemplateUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板更新处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Component
public class WoaMsgTemplateUpdateCmdExe {

    @Resource
    private WoaMsgTemplateGateway woaMsgTemplateGateway;

    public WoaMsgTemplateVO execute(WoaMsgTemplateUpdateCmd cmd) {
        return WoaMsgTemplateAssembler.toVo(woaMsgTemplateGateway.update(WoaMsgTemplateAssembler.toUpdateEntity(cmd)));
    }

}
