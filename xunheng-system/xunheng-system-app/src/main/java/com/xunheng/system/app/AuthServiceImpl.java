package com.xunheng.system.app;

import com.xunheng.base.utils.IpUtils;
import com.xunheng.system.app.executor.AuthLoginCmdExe;
import com.xunheng.system.app.executor.AuthLogoutCmdExe;
import com.xunheng.system.client.api.AuthService;
import com.xunheng.system.client.dto.AuthLoginCmd;
import com.xunheng.system.client.dto.VO.LoginVO;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import jakarta.annotation.Resource;

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
    public LoginVO login(AuthLoginCmd cmd, HttpServletRequest request) {
        //webflux方式获取ip
        cmd.setIp(IpUtils.getIpAddr(request));
        return authLoginCmdExe.execute(cmd);
    }

    @Override
    public void logout() {
        authLogoutCmdExe.execute();
    }
}
