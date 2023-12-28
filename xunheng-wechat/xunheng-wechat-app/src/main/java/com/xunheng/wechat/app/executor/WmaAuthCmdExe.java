package com.xunheng.wechat.app.executor;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import com.xunheng.wechat.client.dto.VO.WmaAuthVO;
import com.xunheng.wechat.client.dto.WmaAuthCmd;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Component;


@Component
@Slf4j
public class WmaAuthCmdExe {

    @Resource
    WxMaService wxMaService;

    public WmaAuthVO execute(WmaAuthCmd cmd) {
        try {
            wxMaService.switchover(cmd.getAppId());
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(cmd.getCode());
            String openId = session.getOpenid();
            String sessionKey = session.getSessionKey();
            String unionId = session.getUnionid();
            log.info(openId+"/"+sessionKey+"/"+unionId);
            /*进行平台登录 将微信的token跟平台登录后的token一同返回 */
            return new WmaAuthVO();
        } catch (WxErrorException e) {
            e.printStackTrace();
        }
        return null;
    }
}
