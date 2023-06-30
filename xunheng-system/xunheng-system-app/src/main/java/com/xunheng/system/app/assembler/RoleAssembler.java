package com.xunheng.system.app.assembler;

import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.system.client.dto.RoleSaveCmd;
import com.xunheng.system.domain.role.model.RoleEntity;

import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:36
 */
public class RoleAssembler {

    public static RoleEntity toSaveEntity(RoleSaveCmd cmd) {
        RoleEntity entity = new RoleEntity();
        entity.setId(cmd.getId());
        entity.setName(cmd.getName());
        entity.setDescription(cmd.getDescription());
        return entity;
    }

    public static RoleVO toVo(RoleEntity entity) {
        if(entity == null)return null;
        RoleVO vo = new RoleVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setDataType(entity.getDataType());
        vo.setDataLevel(entity.getDataLevel());
        vo.setCustomExpression(entity.getCustomExpression());
        vo.setIncludeLow(entity.getIncludeLow());
        vo.setDescription(entity.getDescription());
        vo.setOrganizationIds(entity.getOrganizationIds());
        if(entity.getPermissions() != null)vo.setPermissions(entity.getPermissions().stream().map(RolePermissionAssembler::toVo).collect(Collectors.toList()));
        return vo;
    }

    public static SelectItemVO toSelectItem(RoleEntity entity) {
        if(entity == null)return null;
        SelectItemVO item = new SelectItemVO();
        item.setDescription(entity.getDescription());
        item.setTitle(entity.getName());
        item.setValue(entity.getId());
        item.setId(entity.getId());
        return item;
    }
}
