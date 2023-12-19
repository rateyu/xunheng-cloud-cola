package com.xunheng.wechat.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.wechat.app.assembler.WechatQrCodeAssembler;
import com.xunheng.wechat.client.dto.WechatQrCodeCreateCmd;
import com.xunheng.wechat.client.dto.VO.WechatQrCodeVO;
import com.xunheng.wechat.domain.account.gateway.WechatQrCodeGateway;
import com.xunheng.wechat.domain.account.model.WechatQrCodeEntity;
import io.seata.common.util.StringUtils;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.result.WxMpQrCodeTicket;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息创建处理器
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Component
public class WechatQrCodeCreateCmdExe {

    @Resource
    private WechatQrCodeGateway wechatQrCodeGateway;

    @Resource
    private WxMpService wxMpService;

    public WechatQrCodeVO execute(WechatQrCodeCreateCmd cmd) {
        try {
            if(StringUtils.isEmpty(cmd.getAppId()))throw new GlobalException("未选择账号！");
            WxMpQrCodeTicket ticket;
            if (cmd.getType().equals("temp")) {//创建临时二维码
                ticket = wxMpService.getQrcodeService().qrCodeCreateTmpTicket(cmd.getSceneStr(), cmd.getExpireSeconds());
            } else {//创建永久二维码
                ticket = wxMpService.getQrcodeService().qrCodeCreateLastTicket(cmd.getSceneStr());
            }
            /*保存至数据库*/
            WechatQrCodeEntity createEntity = WechatQrCodeAssembler.toCreateEntity(cmd);
            createEntity.setTicket(ticket.getTicket());
            createEntity.setUrl(ticket.getUrl());
            if (cmd.getType().equals("temp")) {
                createEntity.setExpireTime(new Date(System.currentTimeMillis() + ticket.getExpireSeconds() * 1000L));
            }
            return WechatQrCodeAssembler.toVo(wechatQrCodeGateway.create(createEntity));
        } catch (WxErrorException e) {
            throw new RuntimeException(e);
        }
    }

}
