package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.Permission;
import com.xunheng.system.infrastructure.convertor.PermissionConvertor;
import com.xunheng.system.domain.permission.gateway.PermissionGateway;
import com.xunheng.system.infrastructure.mapper.PermissionMapper;
import com.xunheng.system.domain.permission.model.PermissionEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:47
 */
@Component
public class PermissionGatewayImpl implements PermissionGateway {

    @Resource
    PermissionMapper permissionMapper;

    @Override
    public List<PermissionEntity> getPermissionListByUserId(String userId,Boolean isSuperAdmin) {
        List<Permission> userPermissionList = permissionMapper.getUserPermissionList(userId,isSuperAdmin);
        return userPermissionList.stream().map(PermissionConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<PermissionEntity> getSystemPermissionList() {
        List<Permission> permissionList = permissionMapper.getSystemPermissionList();
        return permissionList.stream().map(PermissionConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public PermissionEntity saveOrUpdate(PermissionEntity entity) {
        Permission permission = PermissionConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(permission.getId()) ? permissionMapper.insert(permission) : permissionMapper.updateById(permission);
        return PermissionConvertor.toEntity(permission);
    }

    @Override
    public PermissionEntity getOneByName(String name) {
        QueryWrapper<Permission> wrapper = new QueryWrapper<>();
        wrapper.eq("name",name);
        return PermissionConvertor.toEntity(permissionMapper.selectOne(wrapper));
    }

    @Override
    public void remove(String id) {
        permissionMapper.deleteById(id);
    }
}
