package com.xunheng.system.domain.organization.ability;

import com.xunheng.system.domain.organization.model.OrganizationEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构领域服务
 * @author: hhqkkr
 * @date: 2023/6/29 23:59
 */
public interface OrganizationDomainService {

    /**
     * 组织架构新增
     * @param entity 组织架构实体
     * @return 组织架构实体
     */
    OrganizationEntity create(OrganizationEntity entity);

    /**
     * 组织架构更新
     * @param entity 组织架构实体
     * @return 组织架构实体
     */
    OrganizationEntity update(OrganizationEntity entity);
}
