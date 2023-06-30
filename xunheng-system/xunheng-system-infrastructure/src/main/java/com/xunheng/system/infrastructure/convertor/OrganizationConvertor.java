package com.xunheng.system.infrastructure.convertor;

import com.xunheng.system.infrastructure.DO.Organization;
import com.xunheng.system.domain.organization.model.OrganizationEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织结构DO转换
 * @author: hhqkkr
 * @date: 2023/6/30 00:26
 */
public class OrganizationConvertor {

    public static Organization toDO(OrganizationEntity entity) {
        Organization db = new Organization();
        db.setId(entity.getId());
        db.setTitle(entity.getTitle());
        db.setParentId(entity.getParentId());
        db.setSortOrder(entity.getSortOrder());
        db.setStatus(entity.getStatus());
        db.setType(entity.getType());
        db.setTenantId(entity.getTenantId());
        db.setSubCompanyId(entity.getSubCompanyId());
        return db;
    }

    public static OrganizationEntity toEntity(Organization db) {
        if(db == null)return null;
        OrganizationEntity entity = new OrganizationEntity();
        entity.setId(db.getId());
        entity.setTitle(db.getTitle());
        entity.setParentId(db.getParentId());
        entity.setSortOrder(db.getSortOrder());
        entity.setStatus(db.getStatus());
        entity.setType(db.getType());
        entity.setTenantId(db.getTenantId());
        entity.setSubCompanyId(db.getSubCompanyId());
        return entity;
    }
}
