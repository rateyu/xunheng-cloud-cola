
package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.system.domain.tenant.gateway.TenantAuthRecordGateway;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户删除操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:30
 */
@Component
public class TenantRemoveCmdExe {

    @Resource
    private TenantGateway tenantGateway;

    public void execute(String id) {
        TenantEntity detail = tenantGateway.getOneById(id);
        if(detail.getEndDate() != null)throw new GlobalException("该租户已存在授权记录，无法删除.");
        tenantGateway.remove(id);
    }

}
