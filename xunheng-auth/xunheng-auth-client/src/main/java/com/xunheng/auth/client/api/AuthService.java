package com.xunheng.auth.client.api;

import com.xunheng.auth.client.dto.AuthLoginCmd;
import com.xunheng.auth.client.dto.VO.LoginVO;
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
    LoginVO login(AuthLoginCmd cmd, ServerHttpRequest request);

    /**
     * 用户登出
     */
    void logout();

}
