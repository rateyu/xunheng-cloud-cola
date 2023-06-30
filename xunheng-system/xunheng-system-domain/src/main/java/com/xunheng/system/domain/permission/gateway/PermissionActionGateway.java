package com.xunheng.system.domain.permission.gateway;

import com.xunheng.system.domain.permission.model.PermissionActionEntity;

import java.util.List;

public interface PermissionActionGateway {
    void batchCreate(String permissionId,List<PermissionActionEntity> actionList);

    void removeByPermissionId(String permissionId);

    List<PermissionActionEntity> getByPermissionId(String permissionId);

    List<String> getCodesByUserId(String userId);
}
