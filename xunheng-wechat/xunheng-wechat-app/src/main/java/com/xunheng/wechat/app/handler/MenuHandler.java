package com.xunheng.wechat.app.handler;

import com.xunheng.wechat.domain.customerService.ability.CustomerServiceDomainService;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.util.WxMpConfigStorageHolder;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Map;

/**
 * @author Binary Wang
 */
@Component
public class MenuHandler extends AbstractHandler {

    @Resource
    CustomerServiceDomainService customerServiceDomainService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService weixinService,
                                    WxSessionManager sessionManager) {
        if (WxConsts.EventType.VIEW.equals(wxMessage.getEvent())) {
            return null;
        }
        String appid = WxMpConfigStorageHolder.get();
        logger.info("菜单事件：" + wxMessage.getEventKey());
        customerServiceDomainService.tryAutoReply(appid, 1, wxMessage.getFromUser(), wxMessage.getEventKey());
        return null;
    }


}
