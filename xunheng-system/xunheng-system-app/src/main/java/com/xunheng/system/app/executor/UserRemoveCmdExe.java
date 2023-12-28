
package com.xunheng.system.app.executor;

import com.xunheng.security.config.util.SaUtil;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.gateway.UserRoleGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:36
 */
@Component
public class UserRemoveCmdExe {

    @Resource
    private UserGateway userGateway;

    @Resource
    private UserRoleGateway userRoleGateway;

    @Resource
    private UserDomainService userDomainService;

    @Resource
    private SaUtil saUtil;

    public void execute(String id) {
        userDomainService.reloadUserDetailCache(id);
        userGateway.remove(id);
        /*删除关联角色*/
        userRoleGateway.removeByUserId(id);
        /*删除权限缓存*/
        saUtil.deleteCustomerSession("permission:"+id);
    }

}
