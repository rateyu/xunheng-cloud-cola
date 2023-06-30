package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.TenantSaveCmd;
import com.xunheng.system.client.dto.VO.TenantVO;
import com.xunheng.system.domain.tenant.model.TenantEntity;
/**
 * @program: xunheng-cloud-cola
 * @description: 租户dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:38
 */
public class TenantAssembler {
    public static TenantEntity toSaveEntity(TenantSaveCmd cmd) {
        TenantEntity entity = new TenantEntity();
        entity.setId(cmd.getId());
        entity.setCode(cmd.getCode());
        entity.setName(cmd.getName());
        entity.setContactor(cmd.getContactor());
        entity.setContact(cmd.getContact());
        entity.setAddress(cmd.getAddress());
        entity.setEndDate(cmd.getEndDate());
        return entity;
    }

    public static TenantVO toVo(TenantEntity entity) {
        if(entity == null)return null;
        TenantVO vo = new TenantVO();
        vo.setId(entity.getId());
        vo.setCode(entity.getCode());
        vo.setName(entity.getName());
        vo.setContact(entity.getContact());
        vo.setContactor(entity.getContactor());
        vo.setAddress(entity.getAddress());
        vo.setEndDate(entity.getEndDate());
        return vo;
    }
}
