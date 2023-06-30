package com.xunheng.system.app.assembler;

import com.xunheng.base.vo.system.PermissionActionVO;
import com.xunheng.system.domain.permission.model.PermissionActionEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限功能操作dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:33
 */
public class PermissionActionAssembler {

    public static PermissionActionEntity toSaveEntity(PermissionActionVO vo) {
        PermissionActionEntity entity = new PermissionActionEntity();
        entity.setPermissionId(vo.getPermissionId());
        entity.setName(vo.getName());
        entity.setCode(vo.getCode());
        entity.setStatus(vo.getStatus());
        return entity;
    }

    public static PermissionActionVO toVo(PermissionActionEntity entity) {
        if(entity == null)return null;
        PermissionActionVO vo = new PermissionActionVO();
        vo.setPermissionId(entity.getPermissionId());
        vo.setName(entity.getName());
        vo.setCode(entity.getCode());
        vo.setStatus(entity.getStatus());
        return vo;
    }
}
