package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WoaMsgAssembler;
import com.xunheng.wechat.client.dto.WoaMsgUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WoaMsgVO;
import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息更新处理器
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Component
public class WoaMsgUpdateCmdExe {

    @Resource
    private WoaMsgGateway woaMsgGateway;

    public WoaMsgVO execute(WoaMsgUpdateCmd cmd) {
        return WoaMsgAssembler.toVo(woaMsgGateway.update(WoaMsgAssembler.toUpdateEntity(cmd)));
    }

}
