
package com.xunheng.system.app.executor;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.security.config.util.SaUtil;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户状态更新操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:33
 */
@Component
public class UserStatusChangeCmdExe {
    @Resource
    private UserGateway userGateway;

    @Resource
    private UserDomainService userDomainService;

    @Resource
    private SaUtil saUtil;

    public void execute(String userId,Boolean enable) {
        /*更新用户状态*/
        UserEntity user = new UserEntity();
        user.setId(userId);
        user.setStatus(enable?CommonConstant.USER_STATUS_NORMAL:CommonConstant.USER_STATUS_LOCK);
        userGateway.saveOrUpdate(user);
        /*刷新用户缓存 删除该用户的权限信息*/
        userDomainService.reloadUserDetailCache(user.getId());
        saUtil.deleteCustomerSession("permission:"+userId);
    }

}
