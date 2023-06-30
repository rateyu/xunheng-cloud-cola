package com.xunheng.auth.app;

import com.xunheng.auth.app.executor.AuthLoginCmdExe;
import com.xunheng.auth.app.executor.AuthLogoutCmdExe;
import com.xunheng.auth.client.api.AuthService;
import com.xunheng.auth.client.dto.AuthLoginCmd;
import com.xunheng.auth.client.dto.VO.LoginVO;
import com.xunheng.auth.infrastructure.utils.WebFluxHttpUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 网关登陆service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 12:35
 */
@Service
@Slf4j
@Transactional
public class AuthServiceImpl implements AuthService {

    @Resource
    private AuthLoginCmdExe authLoginCmdExe;

    @Resource
    private AuthLogoutCmdExe authLogoutCmdExe;

    @Override
    public LoginVO login(AuthLoginCmd cmd, ServerHttpRequest request) {
        //webflux方式获取ip
        cmd.setIp(WebFluxHttpUtil.getIpAddress(request));
        return authLoginCmdExe.execute(cmd);
    }

    @Override
    public void logout() {
        authLogoutCmdExe.execute();
    }
}
