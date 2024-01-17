package com.xunheng.system.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.app.assembler.TenantAuthRecordAssembler;
import com.xunheng.system.client.dto.query.TenantAuthRecordPageQuery;
import com.xunheng.system.client.dto.VO.TenantAuthRecordVO;
import com.xunheng.system.domain.tenant.gateway.TenantAuthRecordGateway;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录分页查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:00
 */
@Component
public class TenantAuthRecordPageQueryExe {
    
    @Resource
    TenantAuthRecordGateway tenantAuthRecordGateway;

    public IPage<TenantAuthRecordVO> execute(TenantAuthRecordPageQuery query) {
        IPage<TenantAuthRecordEntity> page = tenantAuthRecordGateway.pageList(query);
        return page.convert(TenantAuthRecordAssembler::toVo);
    }
}
