package com.xunheng.system.domain.permission.gateway;


import com.xunheng.system.domain.permission.model.PermissionEntity;

import java.util.List;

public interface PermissionGateway {

    List<PermissionEntity> getPermissionListByUserId(String userId,Boolean isSuperAdmin);



    List<PermissionEntity> getSystemPermissionList();

    PermissionEntity saveOrUpdate(PermissionEntity createEntity);

    PermissionEntity getOneByName(String name);

    void remove(String id);
}
