package com.xunheng.wechat.app.executor;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.bean.WxMaJscode2SessionResult;
import cn.dev33.satoken.session.SaSession;
import com.xunheng.base.constant.SaSessionConstant;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.utils.DateUtil;
import com.xunheng.log.client.api.BaseFeignLogService;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.base.utils.StpWmaUtil;
import com.xunheng.wechat.client.dto.VO.WmaAuthVO;
import com.xunheng.wechat.client.dto.WmaAuthCmd;
import com.xunheng.wechat.domain.wechatUser.gateway.WechatUserGateway;
import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;
import io.seata.common.util.StringUtils;
import jakarta.annotation.Resource;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.common.error.WxErrorException;
import org.springframework.stereotype.Component;

import java.util.Date;


@Component
@Slf4j
public class WmaAuthCmdExe {

    @Resource
    WxMaService wxMaService;

    @Resource
    private BaseFeignLogService baseFeignLogService;

    @Resource
    private WechatUserGateway wechatUserGateway;

    public WmaAuthVO execute(WmaAuthCmd cmd) {
        try {
            wxMaService.switchover(cmd.getAppId());
            WxMaJscode2SessionResult session = wxMaService.getUserService().getSessionInfo(cmd.getCode());
            String openId = session.getOpenid();
            String sessionKey = session.getSessionKey();
            String unionId = session.getUnionid();
            log.info(openId+"/"+sessionKey+"/"+unionId);
            /*用openId进行平台登录 将微信的token跟平台登录后的token一同返回 */
            StpWmaUtil.login(openId, SaSessionConstant.LOGIN_DEVICE_WMA);
            /*拿到登录成功后的token*/
            String token = StpWmaUtil.getTokenValue();
            /*根据openid查询是否为新用户，如果是则新增用户，初始化用户名与头像*/
            WechatUserEntity wmaUser = wechatUserGateway.getOneByOpenId(cmd.getAppId(), openId);
            if(wmaUser == null){
                wmaUser = WechatUserEntity.createWmaUser(cmd.getAppId(), openId, unionId);
                wechatUserGateway.create(wmaUser);
            }
            /*存放一些信息到tokenSession*/
            SaSession tokenSession = StpWmaUtil.getTokenSession();
            tokenSession.set("loginTime", DateUtil.dateFormatToStr(DateUtil.DATE_TIME_FORMAT2,new Date()));//登录时间
            tokenSession.set("device",SaSessionConstant.LOGIN_DEVICE_WMA);//登录设备 微信小程序
            tokenSession.set("token",token);//登录token
            tokenSession.set("sessionKey",sessionKey);//微信sessionKey
            if(StringUtils.isNotEmpty(unionId))tokenSession.set("unionId",unionId);//微信unionId
            tokenSession.set("appId",cmd.getAppId());//对应appId
            /*保存登录日志*/
            LogCreateCmd log = new LogCreateCmd();
            log.setModule("微信小程序登录");
            log.setTitle("登录");
            log.setBusinessType(BusinessType.LOGIN.name());
            log.setMethod("WmaAuthController.auth");
            log.setRequestMethod("POST");
            log.setOperName(openId);
            log.setOperUrl("/auth");
            log.setStatus(0);
            log.setErrorMsg("");
            baseFeignLogService.save(log);
            /*账号详细信息和token一起返回给客户端*/
            WmaAuthVO vo = new WmaAuthVO();
            vo.setAppId(cmd.getAppId());
            vo.setToken(token);
            vo.setOpenId(openId);
            vo.setNickName(wmaUser.getNickName());
            vo.setHeadImgUrl(wmaUser.getHeadImgUrl());
            return vo;
        } catch (WxErrorException e) {
            e.printStackTrace();
            throw new GlobalException("系统开小差了，请稍后再试。");
        }
    }
}
