package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.TenantAuthRecord;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class TenantAuthRecordConvertor {
    public static TenantAuthRecord toDO(TenantAuthRecordEntity entity) {
        TenantAuthRecord db = new TenantAuthRecord();
        db.setId(entity.getId());
        db.setTenantId(entity.getTenantId());
        db.setAuthDate(entity.getAuthDate());
        db.setEndDate(entity.getEndDate());
        return db;
    }

    public static TenantAuthRecordEntity toEntity(TenantAuthRecord db) {
        if(db == null)return null;
        TenantAuthRecordEntity entity = new TenantAuthRecordEntity();
        entity.setId(db.getId());
        entity.setTenantId(db.getTenantId());
        entity.setAuthDate(db.getAuthDate());
        entity.setEndDate(db.getEndDate());
        entity.setTenantName(db.getTenantName());
        return entity;
    }
}
