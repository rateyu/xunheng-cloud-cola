package com.xunheng.wechat.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.wechat.client.api.WmaAuthService;
import com.xunheng.wechat.client.dto.VO.WmaAuthVO;
import com.xunheng.wechat.client.dto.WmaAuthCmd;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.annotation.Resource;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Tag(name="微信小程序授权")
@RestResponse
@RequestMapping("/wma")
public class WmaAuthController {

    @Resource
    private WmaAuthService wmaAuthService;

    @Log(module = "微信授权",title = "微信授权登录", businessType = BusinessType.LOGIN)
    @Operation(summary = "微信登录-code换取openid")
    @RequestMapping(value = "/auth",method = RequestMethod.GET)
    public WmaAuthVO wmaAuth(WmaAuthCmd cmd) {
        return  wmaAuthService.wmaAuth(cmd);
    }

}