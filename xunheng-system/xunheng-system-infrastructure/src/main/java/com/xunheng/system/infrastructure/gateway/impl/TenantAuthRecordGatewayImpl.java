package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.TenantAuthRecord;
import com.xunheng.system.infrastructure.convertor.TenantAuthRecordConvertor;
import com.xunheng.system.client.dto.query.TenantAuthRecordPageQuery;
import com.xunheng.system.domain.tenant.gateway.TenantAuthRecordGateway;
import com.xunheng.system.infrastructure.mapper.TenantAuthRecordMapper;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:43
 */
@Slf4j
@Component
public class TenantAuthRecordGatewayImpl implements TenantAuthRecordGateway {

    @Autowired
    TenantAuthRecordMapper tenantAuthRecordMapper;

    @Override
    public IPage<TenantAuthRecordEntity> pageList(TenantAuthRecordPageQuery query) {
        IPage<TenantAuthRecord> page = tenantAuthRecordMapper.pageList(new Page<TenantAuthRecord>(query.getPage(), query.getPageSize()), query);
        return page.convert(TenantAuthRecordConvertor::toEntity);
    }

    @Override
    public TenantAuthRecordEntity getOneById(String id) {
        TenantAuthRecord record = tenantAuthRecordMapper.selectById(id);
        return TenantAuthRecordConvertor.toEntity(record);
    }

    @Override
    public TenantAuthRecordEntity saveOrUpdate(TenantAuthRecordEntity entity) {
        TenantAuthRecord record = TenantAuthRecordConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(record.getId()) ? tenantAuthRecordMapper.insert(record) : tenantAuthRecordMapper.updateById(record);
        return TenantAuthRecordConvertor.toEntity(record);
    }

    @Override
    public void remove(String id) {
        tenantAuthRecordMapper.deleteById(id);
    }

    @Override
    public TenantAuthRecordEntity getLatestEndDate(String tenantId) {
        QueryWrapper<TenantAuthRecord> wrapper = new QueryWrapper();
        wrapper.eq("tenant_id", tenantId);
        wrapper.orderByDesc("end_date");
        List<TenantAuthRecord> list = tenantAuthRecordMapper.selectList(wrapper);
        if(list == null || list.size() == 0)return new TenantAuthRecordEntity();
        else return TenantAuthRecordConvertor.toEntity(list.get(0));
    }


}
