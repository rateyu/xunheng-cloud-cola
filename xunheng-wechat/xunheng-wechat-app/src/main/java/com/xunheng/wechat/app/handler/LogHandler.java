package com.xunheng.wechat.app.handler;

import com.alibaba.fastjson.JSON;
import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import com.xunheng.wechat.domain.customerService.model.WoaMsgEntity;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Map;

/**
 * @author Binary Wang
 */
@Slf4j
@Component
public class LogHandler extends AbstractHandler {

    @Resource
    WoaMsgGateway woaMsgGateway;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {
        try {
            log.debug("\n接收到请求消息，内容：{}", JSON.toJSONString(wxMessage));
            woaMsgGateway.saveOrUpdate(new WoaMsgEntity(wxMessage));
        } catch (Exception e) {
            this.logger.error("记录消息异常",e);
        }

        return null;
    }

}
