package com.xunheng.system.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.LoginAssembler;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.client.dto.AuthLoginCmd;
import com.xunheng.system.client.dto.VO.LoginVO;
import com.xunheng.system.domain.login.ability.LoginDomainService;
import com.xunheng.system.domain.login.gateway.LoginGateway;
import com.xunheng.system.domain.login.model.LoginEntity;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 登陆操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 12:45
 */
@Component
public class AuthLoginCmdExe {

    @Resource
    private LoginDomainService loginDomainService;

    @Resource
    private UserDomainService userDomainService;

    @Resource
    private LoginGateway loginGateway;

    public LoginVO execute(AuthLoginCmd cmd){
        /*转换为login聚合根*/
        LoginEntity login = LoginAssembler.toEntity(cmd);
        /*登录校验*/
        loginDomainService.checkValidation(login);
        /*通过所有验证后 查询账号详细信息 其中包括权限*/
        UserEntity userEntity = userDomainService.getUserDetailByUsername(login.getUsername());
        UserVO userVO = UserAssembler.toVo(userEntity);
        /*正式登录 使用satoken框架*/
        login.setId(userVO.getId());//补充用户id
        String token = loginDomainService.saLogin(login);
        /*保存登录日志 可以交给mq kafka 或者异步存储*/
        loginGateway.saveLoginLog(userVO,cmd);
        /*账号详细信息和token一起返回给客户端*/
        LoginVO loginVO = new LoginVO();
        loginVO.setUser(userVO);
        loginVO.setToken(token);
        return loginVO;
    }

}
