package com.xunheng.auth.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.auth.domain.login.ability.LoginDomainService;
import com.xunheng.auth.domain.login.gateway.LoginGateway;
import com.xunheng.base.vo.system.UserVO;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

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
    private LoginGateway loginGateway;

    public void execute(){
        /*已经登出了就不处理*/
        if(!StpUtil.isLogin() || StpUtil.getLoginId() == null)return;
        /*获取当前用户信息*/
        UserVO userVO = loginGateway.getUserDetailByUserId(StpUtil.getLoginId(""));
        /*正式登出 使用satoken框架*/
        loginDomainService.saLogout(userVO.getId());
        /*保存登出日志*/
        loginGateway.saveLogoutLog(userVO);
    }
}
