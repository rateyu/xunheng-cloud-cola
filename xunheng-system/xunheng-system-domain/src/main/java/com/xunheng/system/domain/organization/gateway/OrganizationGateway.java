package com.xunheng.system.domain.organization.gateway;

import com.xunheng.system.domain.organization.model.OrganizationEntity;
import com.xunheng.system.client.dto.query.OrganizationListQuery;
import com.xunheng.system.domain.tenant.model.TenantEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:57
 */
public interface OrganizationGateway {

    /**
     * 获取组织架构列表
     * @param query 查询条件dto
     * @return 组织结构列表
     */
    List<OrganizationEntity> getList(OrganizationListQuery query);

    /**
     * 保存或更新组织架构
     * @param entity 组织架构实体
     * @return 组织架构实体
     */
    OrganizationEntity saveOrUpdate(OrganizationEntity entity);

    /**
     * 删除组织架构
     * @param id 组织架构id
     */
    void remove(String id);

    /**
     * 根据id获取组织架构
     * @param id 组织架构id
     * @return 组织架构实体
     */
    OrganizationEntity getOneById(String id);

    /**
     * 获取子组织架构集合
     * @param id 父组织架构集合
     * @return 组织架构集合
     */
    List<OrganizationEntity> getByParentId(String id);

    /**
     * 创建一级组织架构
     * @param tenant 租户信息
     */
    void createTenantOrganization(TenantEntity tenant);

}
