package com.xunheng.system.domain.permission.ability;

import com.xunheng.system.domain.permission.model.PermissionEntity;
import com.xunheng.system.domain.tenant.model.TenantEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限领域服务
 * @author: hhqkkr
 * @date: 2023/6/30 00:10
 */
public interface PermissionDomainService {

    /**
     * 根据用户id获取权限集合
     * @param userId 用户id
     * @return 权限集合
     */
    List<PermissionEntity> getPermissionListByUserId(String userId);

    /**
     * 获取系统页面权限列表
     * @return 权限集合
     */
    List<PermissionEntity> getSystemPermissionList();

    /**
     * 获取用户权限码集合
     * @param userId 用户id
     * @return 权限码集合
     */
    List<String> getUserPermissionCodes(String userId);

}
