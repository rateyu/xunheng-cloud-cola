
package com.xunheng.system.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.system.client.dto.UserPasswordUpdateCmd;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.PassWord;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户更新密码操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:36
 */
@Component
public class UserPasswordUpdateCmdExe {

    @Resource
    private UserGateway userGateway;

    @Resource
    private UserDomainService userDomainService;

    public void execute(UserPasswordUpdateCmd cmd) {
        UserEntity user = userGateway.getOneById(StpUtil.getLoginId(""));
        if(!user.getPassword().isEqual(cmd.getPassword()))throw new GlobalException("旧密码不正确");
        user.setPassword(new PassWord(cmd.getNewPass()));
        userGateway.saveOrUpdate(user);
        //手动更新缓存
        userDomainService.reloadUserDetailCache(user.getId());
    }

}
