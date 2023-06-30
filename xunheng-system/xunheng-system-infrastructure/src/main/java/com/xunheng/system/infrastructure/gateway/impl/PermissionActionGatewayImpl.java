package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.PermissionAction;
import com.xunheng.system.infrastructure.convertor.PermissionActionConvertor;
import com.xunheng.system.domain.permission.gateway.PermissionActionGateway;
import com.xunheng.system.infrastructure.mapper.PermissionActionMapper;
import com.xunheng.system.domain.permission.model.PermissionActionEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限功能网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:47
 */
@Component
public class PermissionActionGatewayImpl implements PermissionActionGateway {

    @Resource
    PermissionActionMapper permissionActionMapper;

    @Override
    public void batchCreate(String permissionId,List<PermissionActionEntity> actionList) {
        for (PermissionActionEntity entity : actionList) {
            entity.setPermissionId(permissionId);
            permissionActionMapper.insert(PermissionActionConvertor.toDO(entity));
        }
    }

    @Override
    public void removeByPermissionId(String permissionId) {
        QueryWrapper<PermissionAction> wrapper = new QueryWrapper<>();
        wrapper.eq("permission_id",permissionId);
        permissionActionMapper.delete(wrapper);
    }

    @Override
    public List<PermissionActionEntity> getByPermissionId(String permissionId) {
        List<PermissionAction> list = permissionActionMapper.getByPermissionId(permissionId);
        return list.stream().map(PermissionActionConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<String> getCodesByUserId(String userId) {
        return permissionActionMapper.getCodesByUserId(userId);
    }
}
