package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import com.xunheng.system.infrastructure.DO.Organization;
import com.xunheng.system.infrastructure.convertor.OrganizationConvertor;
import com.xunheng.system.client.dto.query.OrganizationListQuery;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.infrastructure.mapper.OrganizationMapper;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:32
 */
@Slf4j
@Component
public class OrganizationGatewayImpl implements OrganizationGateway {

    @Resource
    OrganizationMapper organizationMapper;

    @Override
    public List<OrganizationEntity> getList(OrganizationListQuery query) {
        QueryWrapper<Organization> wrapper = new QueryWrapper<>();
        if(StringUtils.isNotEmpty(query.getTenantId()))wrapper.eq("tenant_id",query.getTenantId());
        wrapper.orderByAsc("type,sort_order");
        return organizationMapper.selectList(wrapper).stream().map(OrganizationConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public OrganizationEntity saveOrUpdate(OrganizationEntity entity) {
        Organization organization = OrganizationConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(organization.getId()) ? organizationMapper.insert(organization) : organizationMapper.updateById(organization);
        return OrganizationConvertor.toEntity(organization);
    }

    @Override
    public OrganizationEntity getOneById(String id) {
        Organization organization = organizationMapper.selectById(id);
        return OrganizationConvertor.toEntity(organization);
    }

    @Override
    public List<OrganizationEntity> getByParentId(String parentId) {
        QueryWrapper<Organization> wrapper = new QueryWrapper<>();
        wrapper.eq("parent_id", parentId);
        wrapper.orderByAsc("sort_order");
        return organizationMapper.selectList(wrapper).stream().map(OrganizationConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void createTenantOrganization(TenantEntity tenant) {
        QueryWrapper<Organization> wrapper = new QueryWrapper<>();
        wrapper.eq("tenant_id", tenant.getId());
        wrapper.eq("type", CommonConstant.ORGANIZATION_TENANT);
        long count = organizationMapper.selectCount(wrapper);
        if (count > 0) return;//已经存在就不创建
        Organization organization = new Organization();
        organization.setId(tenant.getId());
        organization.setTitle(tenant.getName());
        organization.setStatus(0);
        organization.setType(CommonConstant.ORGANIZATION_TENANT);
        organization.setTenantId(tenant.getId());
        organizationMapper.insert(organization);
    }

    @Override
    public void remove(String id) {
        organizationMapper.deleteById(id);
    }

}
