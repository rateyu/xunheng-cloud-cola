package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.RestResponse;
import com.xunheng.system.client.api.AuthService;
import com.xunheng.system.client.dto.AuthLoginCmd;
import com.xunheng.system.client.dto.VO.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;


//"登录/登出"
@RestResponse
public class AuthController {

    @Resource
    private AuthService authService;

    @RequestMapping("/login")
    public LoginVO login(@RequestBody @Validated AuthLoginCmd cmd, HttpServletRequest request) {
        return authService.login(cmd,request);
    }

    @RequestMapping("/logout")
    public  String logout() {
        authService.logout();
        return "注销登录成功！";
    }

}
