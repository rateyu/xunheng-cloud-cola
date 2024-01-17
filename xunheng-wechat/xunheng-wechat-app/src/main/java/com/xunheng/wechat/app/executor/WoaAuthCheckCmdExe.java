package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.client.dto.WoaAuthCheckCmd;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信消息验证处理器
 * @author: hhqkkr
 * @date: 2023/7/25 13:39
 */
@Slf4j
@Component
public class WoaAuthCheckCmdExe {

    @Resource
    WxMpService wxMpService;

    public String execute(String appId, WoaAuthCheckCmd cmd){
        log.info("\n接收到来自微信服务器的认证消息：[{}, {}, {}, {}]", cmd.getSignature(),
                cmd.getTimestamp(), cmd.getNonce(), cmd.getEchostr());
        if (StringUtils.isAnyBlank(cmd.getSignature(), cmd.getTimestamp(), cmd.getNonce(), cmd.getEchostr())) {
            throw new IllegalArgumentException("请求参数非法，请核实!");
        }

        wxMpService.switchoverTo(appId);

        if (wxMpService.checkSignature(cmd.getTimestamp(),  cmd.getNonce(), cmd.getSignature())) {
            return cmd.getEchostr();
        }

        return "非法请求";
    }
}
