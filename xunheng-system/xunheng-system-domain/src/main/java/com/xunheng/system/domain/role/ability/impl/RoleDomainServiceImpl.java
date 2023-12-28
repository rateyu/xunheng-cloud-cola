package com.xunheng.system.domain.role.ability.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.query.RolePageQuery;
import com.xunheng.system.domain.role.ability.RoleDomainService;
import com.xunheng.system.domain.role.gateway.RolePermissionGateway;
import com.xunheng.system.domain.role.gateway.RoleGateway;
import com.xunheng.system.domain.role.model.RoleEntity;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;

@Service
public class RoleDomainServiceImpl implements RoleDomainService {

    @Resource
    RoleGateway roleGateway;

    @Resource
    RolePermissionGateway rolePermissionGateway;

    @Override
    public IPage<RoleEntity> pageList(RolePageQuery query) {
        IPage<RoleEntity> page = roleGateway.pageList(query);
        /*补全权限与数据权限范围*/
        for(RoleEntity role : page.getRecords()){
            /*角色拥有菜单权限*/
            role.setPermissions(rolePermissionGateway.getByRoleId(role.getId()));
        }
        return page;
    }
}
