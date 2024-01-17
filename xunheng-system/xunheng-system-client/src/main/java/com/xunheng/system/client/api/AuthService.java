package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.AuthLoginCmd;
import com.xunheng.system.client.dto.VO.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.server.reactive.ServerHttpRequest;

/**
 * @program: xunheng-cloud-cola
 * @description: 网关登陆service
 * @author: hhqkkr
 * @date: 2023/6/29 12:34
 */
public interface AuthService {

    /**
     * 用户登陆
     * @param cmd 登陆操作DTO
     * @param request request 用于获取id
     * @return 登陆VO
     */
    LoginVO login(AuthLoginCmd cmd, HttpServletRequest request);

    /**
     * 用户登出
     */
    void logout();

}
