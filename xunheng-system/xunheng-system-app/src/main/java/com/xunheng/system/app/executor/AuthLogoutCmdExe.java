package com.xunheng.system.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.domain.login.ability.LoginDomainService;
import com.xunheng.system.domain.login.gateway.LoginGateway;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 登出操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 12:48
 */
@Component
public class AuthLogoutCmdExe {

    @Resource
    private LoginDomainService loginDomainService;

    @Resource
    private UserDomainService userDomainService;

    @Resource
    private LoginGateway loginGateway;

    public void execute(){
        /*已经登出了就不处理*/
        if(!StpUtil.isLogin() || StpUtil.getLoginId() == null)return;
        /*获取当前用户信息*/
        UserEntity userEntity = userDomainService.getUserDetailById(StpUtil.getLoginId(""));
        UserVO userVO = UserAssembler.toVo(userEntity);
        /*正式登出 使用satoken框架*/
        loginDomainService.saLogout(userVO.getId());
        /*保存登出日志*/
        loginGateway.saveLogoutLog(userVO);
    }
}
