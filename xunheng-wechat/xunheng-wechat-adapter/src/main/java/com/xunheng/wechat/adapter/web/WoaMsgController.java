package com.xunheng.wechat.adapter.web;

import com.xunheng.base.annotation.ResponseNotIntercept;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.wechat.client.api.WoaMsgService;
import com.xunheng.wechat.client.dto.WoaAuthCheckCmd;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import me.chanjar.weixin.mp.api.WxMpMessageRouter;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.message.WxMpXmlMessage;
import me.chanjar.weixin.mp.bean.message.WxMpXmlOutMessage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@Tag(name="公众号验证与消息接收")
@RestResponse
@RequestMapping("/woa/msg/{appId}")
@ResponseNotIntercept
public class WoaMsgController {

    @Resource
    private WoaMsgService woaMsgService;

    @Operation(summary = "接入验证")
    @GetMapping(produces = "text/plain;charset=utf-8")
    public String authCheck(@PathVariable String appId, WoaAuthCheckCmd cmd) {
        return  woaMsgService.authCheck(appId,cmd);
    }

    @PostMapping(produces = "application/xml; charset=UTF-8")
    public String post(@PathVariable String appId,
                       @RequestBody String requestBody,
                       @RequestParam("signature") String signature,
                       @RequestParam("timestamp") String timestamp,
                       @RequestParam("nonce") String nonce,
                       @RequestParam("openid") String openid,
                       @RequestParam(name = "encrypt_type", required = false) String encType,
                       @RequestParam(name = "msg_signature", required = false) String msgSignature) {
        return null;
    }

}