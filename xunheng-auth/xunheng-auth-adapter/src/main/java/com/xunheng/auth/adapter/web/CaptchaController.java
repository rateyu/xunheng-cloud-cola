package com.xunheng.auth.adapter.web;

import com.xunheng.auth.client.api.CaptchaService;
import com.xunheng.auth.client.dto.VO.CaptchaVO;
import com.xunheng.base.utils.ResultUtil;
import com.xunheng.base.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Api("验证码")
@RestController
@RequestMapping("/captcha")
public class CaptchaController {

    @Autowired
    CaptchaService captchaService;

    @RequestMapping(value = "/load",method = RequestMethod.GET)
    @ApiOperation(value = "加载验证码")
    public ResultVO<CaptchaVO> load(){
       return new ResultUtil<CaptchaVO>().setData(captchaService.loadCaptcha());
    }

}
