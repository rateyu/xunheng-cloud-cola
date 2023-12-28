package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WechatQrCodeAssembler;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.domain.account.gateway.WechatQrCodeGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息详情查询处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Component
public class WechatQrCodeDetailQueryExe {
    @Resource
    WechatQrCodeGateway wechatQrCodeGateway;

    public WechatQrCodeVO execute(String id) {
        return WechatQrCodeAssembler.toVo(wechatQrCodeGateway.getOneById(id));
    }
}

