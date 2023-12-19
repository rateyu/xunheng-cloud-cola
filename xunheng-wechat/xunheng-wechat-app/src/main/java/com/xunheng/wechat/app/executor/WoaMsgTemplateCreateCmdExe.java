package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaMsgTemplateAssembler;
import com.xunheng.wechat.client.dto.WoaMsgTemplateCreateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgTemplateVO;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板创建处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Component
public class WoaMsgTemplateCreateCmdExe {

    @Resource
    private WoaMsgTemplateGateway woaMsgTemplateGateway;

    public WoaMsgTemplateVO execute(WoaMsgTemplateCreateCmd cmd) {
        return WoaMsgTemplateAssembler.toVo(woaMsgTemplateGateway.create(WoaMsgTemplateAssembler.toCreateEntity(cmd)));
    }

}
