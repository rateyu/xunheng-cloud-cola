package com.xunheng.system.app.assembler;

import com.xunheng.base.vo.system.UserRoleVO;
import com.xunheng.system.domain.user.model.UserRoleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户角色dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:39
 */
public class UserRoleAssembler {
    public static UserRoleEntity toEntity(UserRoleVO vo) {
        UserRoleEntity entity = new UserRoleEntity();
        entity.setId(vo.getId());
        entity.setUserId(vo.getUserId());
        entity.setRoleId(vo.getRoleId());
        entity.setRoleName(vo.getRoleName());
        entity.setRoleDescription(vo.getRoleDescription());
        entity.setDataType(vo.getDataType());
        return entity;
    }

    public static UserRoleVO toVo(UserRoleEntity entity) {
        if(entity == null)return null;
        UserRoleVO vo = new UserRoleVO();
        vo.setId(entity.getId());
        vo.setUserId(entity.getUserId());
        vo.setRoleId(entity.getRoleId());
        vo.setRoleName(entity.getRoleName());
        vo.setRoleDescription(entity.getRoleDescription());
        vo.setDataType(entity.getDataType());
        return vo;
    }
}
