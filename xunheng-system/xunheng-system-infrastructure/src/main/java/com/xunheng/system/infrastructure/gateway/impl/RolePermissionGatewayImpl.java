package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.RolePermission;
import com.xunheng.system.infrastructure.convertor.RolePermissionConvertor;
import com.xunheng.system.domain.role.gateway.RolePermissionGateway;
import com.xunheng.system.infrastructure.mapper.RolePermissionMapper;
import com.xunheng.system.domain.role.model.RolePermissionEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色权限网关实现
 * @author: hhqkkr
 * @date: 2023/6/30 00:46
 */
@Component
public class RolePermissionGatewayImpl implements RolePermissionGateway {

    @Resource
    RolePermissionMapper rolePermissionMapper;

    @Override
    public List<RolePermissionEntity> getByRoleId(String roleId) {
        QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        List<RolePermission> list = rolePermissionMapper.selectList(wrapper);
        return list.stream().map(RolePermissionConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void deleteByRoleId(String roleId) {
        QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        rolePermissionMapper.delete(wrapper);
    }

    @Override
    public void create(RolePermissionEntity rolePermission) {
        rolePermissionMapper.insert(RolePermissionConvertor.toDO(rolePermission));
    }

    @Override
    public List<RolePermissionEntity> getByPermissionId(String permissionId) {
        QueryWrapper<RolePermission> wrapper = new QueryWrapper<>();
        wrapper.eq("permission_id",permissionId);
        List<RolePermission> list = rolePermissionMapper.selectList(wrapper);
        return list.stream().map(RolePermissionConvertor::toEntity).collect(Collectors.toList());
    }
}
