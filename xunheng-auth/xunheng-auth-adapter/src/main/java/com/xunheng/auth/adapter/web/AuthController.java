package com.xunheng.auth.adapter.web;

import com.xunheng.auth.client.api.AuthService;
import com.xunheng.auth.client.dto.AuthLoginCmd;
import com.xunheng.auth.client.dto.VO.LoginVO;
import com.xunheng.base.utils.ResultUtil;
import com.xunheng.base.vo.ResultVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;


@Api("登录/登出")
@RestController
public class AuthController {

    @Resource
    private AuthService authService;

    @RequestMapping("/login")
    @ApiOperation(value = "登录")
    public ResultVO<LoginVO> login(@RequestBody @Validated AuthLoginCmd cmd, ServerHttpRequest request) {
        return new ResultUtil<LoginVO>().setData(authService.login(cmd,request));
    }

    @RequestMapping("/logout")
    @ApiOperation(value = "登出")
    public  ResultVO<String> logout() {
        authService.logout();
        return new ResultUtil<String>().setData("注销登录成功！");
    }

}
