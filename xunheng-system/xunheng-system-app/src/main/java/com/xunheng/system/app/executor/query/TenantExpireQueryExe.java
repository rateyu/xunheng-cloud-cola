package com.xunheng.system.app.executor.query;

import com.xunheng.base.utils.DateUtil;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户是否过期查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:01
 */
@Component
public class TenantExpireQueryExe {

    @Resource
    private TenantGateway tenantGateway;

    public Boolean execute(String tenantId) {
       return tenantGateway.isTenantExpire(tenantId);
    }
}
