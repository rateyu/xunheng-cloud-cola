
package com.xunheng.system.app.executor;

import com.xunheng.system.domain.tenant.gateway.TenantAuthRecordGateway;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录删除处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:29
 */
@Component
public class TenantAuthRecordRemoveCmdExe {

    @Resource
    private TenantAuthRecordGateway tenantAuthRecordGateway;

    @Resource
    private TenantGateway tenantGateway;

    public void execute(String authRecordId) {
        /*删除记录*/
        TenantAuthRecordEntity record = tenantAuthRecordGateway.getOneById(authRecordId);
        tenantAuthRecordGateway.remove(authRecordId);
        /*获取删除后的最后日期*/
        TenantAuthRecordEntity latestRecord = tenantAuthRecordGateway.getLatestEndDate(record.getTenantId());//查询出有效的最后授权记录
        /*更新租户的截止日期*/
        TenantEntity tenant = new TenantEntity();
        tenant.setId(record.getTenantId());
        tenant.setEndDate(latestRecord.getEndDate());
        tenantGateway.saveOrUpdate(tenant);
    }
}
