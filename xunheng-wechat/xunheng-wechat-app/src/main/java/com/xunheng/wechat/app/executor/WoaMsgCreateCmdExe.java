package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaMsgAssembler;
import com.xunheng.wechat.client.dto.WoaMsgCreateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息创建处理器
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Component
public class WoaMsgCreateCmdExe {

    @Resource
    private WoaMsgGateway woaMsgGateway;

    public WoaMsgVO execute(WoaMsgCreateCmd cmd) {
        return WoaMsgAssembler.toVo(woaMsgGateway.create(WoaMsgAssembler.toCreateEntity(cmd)));
    }

}
