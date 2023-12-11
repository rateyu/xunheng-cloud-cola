package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.app.assembler.WechatQrCodeAssembler;
import com.xunheng.wechat.client.dto.WechatQrCodeUpdateCmd;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.domain.account.gateway.WechatQrCodeGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息更新处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Component
public class WechatQrCodeUpdateCmdExe {

    @Resource
    private WechatQrCodeGateway wechatQrCodeGateway;

    public WechatQrCodeVO execute(WechatQrCodeUpdateCmd cmd) {
        return WechatQrCodeAssembler.toVo(wechatQrCodeGateway.update(WechatQrCodeAssembler.toUpdateEntity(cmd)));
    }

}
