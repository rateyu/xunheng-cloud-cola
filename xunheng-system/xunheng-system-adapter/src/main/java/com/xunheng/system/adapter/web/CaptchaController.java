package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.system.client.api.CaptchaService;
import com.xunheng.system.client.dto.VO.CaptchaVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestResponse
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    CaptchaService captchaService;

    @RequestMapping(value = "/load",method = RequestMethod.GET)
    public CaptchaVO load(){
       return captchaService.loadCaptcha();
    }

}
