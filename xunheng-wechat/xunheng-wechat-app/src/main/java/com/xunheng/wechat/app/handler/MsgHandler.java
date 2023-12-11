package com.xunheng.wechat.app.handler;


import com.xunheng.wechat.domain.customerService.ability.CustomerServiceDomainService;
import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import com.xunheng.wechat.domain.customerService.model.WoaMsgEntity;
import me.chanjar.weixin.common.api.WxConsts;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.util.WxMpConfigStorageHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author Binary Wang
 */
@Component
public class MsgHandler extends AbstractHandler {

    @Autowired
    CustomerServiceDomainService customerServiceDomainService;

    @Autowired
    WoaMsgGateway woaMsgGateway;

    private static final String TRANSFER_CUSTOMER_SERVICE_KEY = "人工";

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage,
                                    Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {

        String textContent = wxMessage.getContent();
        String fromUser = wxMessage.getFromUser();//openId
        String appid = WxMpConfigStorageHolder.get();
        boolean autoReplied = customerServiceDomainService.tryAutoReply(appid,0, fromUser, textContent);
        //当用户输入关键词如“你好”，“客服”，“人工”等，没有触发自动回复时，并且有客服在线时，把消息转发给在线客服
        if (TRANSFER_CUSTOMER_SERVICE_KEY.equals(textContent) || !autoReplied) {
            woaMsgGateway.saveOrUpdate(WoaMsgEntity.buildOutMsg(WxConsts.KefuMsgType.TRANSFER_CUSTOMER_SERVICE,fromUser,null));
            return WxMpXmlOutMessage
                .TRANSFER_CUSTOMER_SERVICE().fromUser(wxMessage.getToUser())
                .toUser(fromUser).build();
        }
        return null;

    }

}
