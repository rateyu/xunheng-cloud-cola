package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.Tenant;
import com.xunheng.system.infrastructure.convertor.TenantConvertor;
import com.xunheng.system.client.dto.query.TenantPageQuery;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import com.xunheng.system.infrastructure.mapper.TenantMapper;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:42
 */
@Slf4j
@Component
public class TenantGatewayImpl implements TenantGateway {

    @Autowired
    TenantMapper tenantMapper;

    @Override
    public IPage<TenantEntity> pageList(TenantPageQuery query) {
        IPage<Tenant> page = tenantMapper.pageList(new Page<Tenant>(query.getPage(), query.getPageSize()), query);
        return page.convert(TenantConvertor::toEntity);
    }

    @Override
    public TenantEntity getOneById(String id) {
        Tenant tenant = tenantMapper.selectById(id);
        return TenantConvertor.toEntity(tenant);
    }

    @Override
    public TenantEntity saveOrUpdate(TenantEntity entity) {
        Tenant tenant = TenantConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(tenant.getId()) ? tenantMapper.insert(tenant) : tenantMapper.updateById(tenant);
        return TenantConvertor.toEntity(tenant);
    }

    @Override
    public void remove(String id) {
        tenantMapper.deleteById(id);
    }


}
