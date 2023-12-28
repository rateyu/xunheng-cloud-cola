package com.xunheng.system.domain.permission.ability.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.session.SaSessionCustomUtil;
import com.xunheng.base.constant.SaSessionConstant;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.system.domain.permission.gateway.PermissionActionGateway;
import com.xunheng.system.domain.permission.ability.PermissionDomainService;
import com.xunheng.system.domain.permission.gateway.PermissionGateway;
import com.xunheng.system.domain.permission.model.PermissionEntity;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import com.xunheng.system.domain.user.ability.UserDomainService;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

@Service
public class PermissionDomainServiceImpl implements PermissionDomainService {

    @Resource
    private PermissionGateway permissionGateway;

    @Resource
    private UserDomainService userDomainService;

    @Resource
    private PermissionActionGateway permissionActionGateway;

    @Override
    public List<PermissionEntity> getPermissionListByUserId(String userId) {
        /*从缓存获取 获取不到再查询*/
        SaSession session = SaSessionCustomUtil.getSessionById("permission:" + userId);
        List<PermissionEntity> permissionList = session.get(SaSessionConstant.USER_PERMISSION_LIST_KEY,() -> {
            List<PermissionEntity> userPermissionList = permissionGateway.getPermissionListByUserId(userId,userDomainService.isSuperAdmin(userId));
            /*补全权限码信息*/
            userPermissionList.forEach(item -> item.setActionList(permissionActionGateway.getByPermissionId(item.getId())));
            return userPermissionList;
        });
        return permissionList;
    }

    @Override
    public List<PermissionEntity> getSystemPermissionList() {
        List<PermissionEntity> permissionList = permissionGateway.getSystemPermissionList();
        /*补全权限码信息*/
        permissionList.forEach(item -> item.setActionList(permissionActionGateway.getByPermissionId(item.getId())));
        return permissionList;
    }

    @Override
    public List<String> getUserPermissionCodes(String userId) {
        SaSession session = SaSessionCustomUtil.getSessionById("permission:" + userId);
        return session.get(SaSessionConstant.PERMISSION_ACTION_CODE_KEY,() -> permissionActionGateway.getCodesByUserId(userDomainService.isSuperAdmin(userId)? null: userId));
    }

}
