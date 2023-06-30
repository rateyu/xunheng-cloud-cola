package com.xunheng.system.domain.organization.ability.impl;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.domain.organization.ability.OrganizationDomainService;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构领域服务实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:00
 */
@Service
public class OrganizationDomainServiceImpl implements OrganizationDomainService {

    @Resource
    private OrganizationGateway organizationGateway;

    @Override
    public OrganizationEntity create(OrganizationEntity entity) {
        /*先保存信息*/
        OrganizationEntity organizationEntity = organizationGateway.saveOrUpdate(entity);
        /*如果是分公司 则分公司id是自己 需要补充保存完的分公司id 再更新一次*/
        if(organizationEntity.getType().equals(CommonConstant.ORGANIZATION_SUB_COMPANY)){
            organizationEntity.setSubCompanyId(organizationEntity.getId());
            organizationEntity = organizationGateway.saveOrUpdate(organizationEntity);
        }
        return organizationEntity;
    }

    @Override
    public OrganizationEntity update(OrganizationEntity entity) {
        /*先保存先获取修改前的数据信息*/
        OrganizationEntity old = organizationGateway.getOneById(entity.getId());
        String oldType = old.getType();
        String newType = entity.getType();
        if(oldType.equals(CommonConstant.ORGANIZATION_DEPARTMENT) && newType.equals(CommonConstant.ORGANIZATION_SUB_COMPANY)){
            /*部门转分公司 租户id不变 分公司id变自己*/
            entity.setSubCompanyId(entity.getId());
        }else if(oldType.equals(CommonConstant.ORGANIZATION_SUB_COMPANY) && newType.equals(CommonConstant.ORGANIZATION_DEPARTMENT)){
            /*分公司转部门 租户id不变 分公司id变租户id*/
            entity.setSubCompanyId(entity.getTenantId());
        }
        return  organizationGateway.saveOrUpdate(entity);
    }
}
