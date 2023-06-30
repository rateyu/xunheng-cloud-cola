package com.xunheng.system.infrastructure.convertor;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.system.infrastructure.DO.Tenant;
import com.xunheng.system.domain.tenant.model.TenantEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class TenantConvertor {
    public static Tenant toDO(TenantEntity entity) {
        Tenant tenant = new Tenant();
        tenant.setId(entity.getId());
        tenant.setCode(entity.getCode());
        tenant.setName(entity.getName());
        tenant.setContact(entity.getContact());
        tenant.setContactor(entity.getContactor());
        tenant.setAddress(entity.getAddress());
        tenant.setEndDate(entity.getEndDate());
        tenant.setStatus(entity.getStatus() == null? CommonConstant.STATUS_NORMAL : entity.getStatus());
        return tenant;
    }

    public static TenantEntity toEntity(Tenant db) {
        if(db == null)return null;
        TenantEntity entity = new TenantEntity();
        entity.setId(db.getId());
        entity.setCode(db.getCode());
        entity.setName(db.getName());
        entity.setContact(db.getContact());
        entity.setContactor(db.getContactor());
        entity.setAddress(db.getAddress());
        entity.setEndDate(db.getEndDate());
        entity.setStatus(db.getStatus());
        return entity;
    }
}
