package com.xunheng.system.app.executor.query;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import com.xunheng.base.constant.SaSessionConstant;
import com.xunheng.system.domain.permission.gateway.PermissionActionGateway;
import com.xunheng.system.domain.user.ability.UserDomainService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户拥有的权限码查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:04
 */
@Component
public class UserPermissionCodeQueryExe {

    @Resource
    private PermissionActionGateway permissionActionGateway;

    @Resource
    private UserDomainService userDomainService;

    public List<String> execute(String userId){
        /*从缓存获取 获取不到再查询*/
        SaSession session = SaSessionCustomUtil.getSessionById("permission:" + userId);
        /*超级管理员的话则查询所有权限码*/
        return session.get(SaSessionConstant.PERMISSION_ACTION_CODE_KEY,() -> permissionActionGateway.getCodesByUserId(userDomainService.isSuperAdmin(userId)? null: userId));
    }

}
