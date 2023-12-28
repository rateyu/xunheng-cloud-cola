package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.TenantAssembler;
import com.xunheng.system.client.dto.VO.TenantVO;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户详情查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:00
 */
@Component
public class TenantDetailQueryExe {
    @Resource
    TenantGateway tenantGateway;

    public TenantVO execute(String id) {
        return TenantAssembler.toVo(tenantGateway.getOneById(id));
    }
}
