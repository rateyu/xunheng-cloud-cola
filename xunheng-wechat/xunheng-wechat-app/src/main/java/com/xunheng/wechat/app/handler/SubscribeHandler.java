package com.xunheng.wechat.app.handler;

import com.xunheng.wechat.domain.customerService.ability.CustomerServiceDomainService;
import com.xunheng.wechat.domain.fans.ability.FansDomainService;
import me.chanjar.weixin.common.session.WxSessionManager;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import me.chanjar.weixin.mp.util.WxMpConfigStorageHolder;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import jakarta.annotation.Resource;
import java.util.Map;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝关注处理
 * @author: hhqkkr
 * @date: 2023/11/24 12:16:19
 */
@Component
public class SubscribeHandler extends AbstractHandler {

    @Resource
    CustomerServiceDomainService customerServiceDomainService;

    @Resource
    FansDomainService fansDomainService;

    @Override
    public WxMpXmlOutMessage handle(WxMpXmlMessage wxMessage, Map<String, Object> context, WxMpService wxMpService,
                                    WxSessionManager sessionManager) {

        this.logger.info("新关注用户 OPENID: " + wxMessage.getFromUser() + "，事件：" + wxMessage.getEventKey());
        String appid = WxMpConfigStorageHolder.get();
        this.logger.info("appid:{}",appid);
        fansDomainService.refreshFansInfo(wxMessage.getFromUser(),appid);//刷新用户信息
        customerServiceDomainService.tryAutoReply(appid, 1, wxMessage.getFromUser(), wxMessage.getEvent());//回复关注信息
        if (StringUtils.hasText(wxMessage.getEventKey())) {// 处理特殊事件，如用户扫描带参二维码关注
            customerServiceDomainService.tryAutoReply(appid, 1, wxMessage.getFromUser(), wxMessage.getEventKey());
        }
        return null;
    }

    /**
     * 处理特殊请求，比如如果是扫码进来的，可以做相应处理
     */
    protected WxMpXmlOutMessage handleSpecial(WxMpXmlMessage wxMessage) {
        this.logger.info("特殊请求-新关注用户 OPENID: " + wxMessage.getFromUser());
        //对关注事件和扫码事件分别处理
        String appid = WxMpConfigStorageHolder.get();
        fansDomainService.refreshFansInfo(wxMessage.getFromUser(),appid);
        customerServiceDomainService.tryAutoReply(appid, 1, wxMessage.getFromUser(), wxMessage.getEvent());
        if (StringUtils.hasText(wxMessage.getEventKey())) {
            customerServiceDomainService.tryAutoReply(appid, 1, wxMessage.getFromUser(), wxMessage.getEventKey());
        }
        return null;
    }

}
