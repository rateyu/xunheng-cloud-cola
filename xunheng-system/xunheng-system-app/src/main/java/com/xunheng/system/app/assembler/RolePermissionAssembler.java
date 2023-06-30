package com.xunheng.system.app.assembler;

import com.xunheng.base.vo.system.RolePermissionVO;
import com.xunheng.system.domain.role.model.RolePermissionEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色权限dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:37
 */
public class RolePermissionAssembler {

    public static RolePermissionVO toVo(RolePermissionEntity entity) {
        if(entity == null)return null;
        RolePermissionVO vo = new RolePermissionVO();
        vo.setId(entity.getId());
        vo.setRoleId(entity.getRoleId());
        vo.setPermissionId(entity.getPermissionId());
        vo.setIsAllCheck(entity.getIsAllCheck());
        return vo;
    }
}
