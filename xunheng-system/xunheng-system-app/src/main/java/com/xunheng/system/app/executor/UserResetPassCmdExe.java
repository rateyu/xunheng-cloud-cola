
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.PassWord;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户重制密码操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:34
 */
@Component
public class UserResetPassCmdExe {

    @Resource
    private UserGateway userGateway;

    @Resource
    private UserDomainService userDomainService;

    public void execute(String userId) {
        /*更新用户密码 默认为123456*/
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setPassword(new PassWord("123456"));
        userGateway.saveOrUpdate(user);
        /*刷新用户信息缓存*/
        userDomainService.reloadUserDetailCache(user.getId());
    }

}
