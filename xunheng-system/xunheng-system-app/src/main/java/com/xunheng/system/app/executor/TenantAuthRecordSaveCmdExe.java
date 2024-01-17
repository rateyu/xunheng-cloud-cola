
package com.xunheng.system.app.executor;

import com.xunheng.base.exception.GlobalException;
import com.xunheng.base.utils.DateUtil;
import com.xunheng.system.app.assembler.TenantAuthRecordAssembler;
import com.xunheng.system.client.dto.TenantAuthRecordSaveCmd;
import com.xunheng.system.client.dto.VO.TenantAuthRecordVO;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.domain.tenant.gateway.TenantAuthRecordGateway;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录保存操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:30
 */
@Component
public class TenantAuthRecordSaveCmdExe {

    @Resource
    private TenantAuthRecordGateway tenantAuthRecordGateway;

    @Resource
    private TenantGateway tenantGateway;

    @Resource
    private OrganizationGateway organizationGateway;

    public TenantAuthRecordVO execute(TenantAuthRecordSaveCmd cmd) {
        TenantAuthRecordEntity record = TenantAuthRecordAssembler.toSaveEntity(cmd);
        /*校验*/
        String tenantId = record.getTenantId();
        TenantEntity tenant = tenantGateway.getOneById(tenantId);
        if(DateUtil.compareDate(record.getEndDate(),tenant.getEndDate()) <= 0)throw new GlobalException("本次授权到期日应该大于该租户的到期日！");
        /*保存记录*/
        record = tenantAuthRecordGateway.saveOrUpdate(record);
        /*赋值最新的授权到期日*/
        tenant.setEndDate(record.getEndDate());
        tenantGateway.saveOrUpdate(tenant);
        /*创建一级租户组织架构*/
        organizationGateway.createTenantOrganization(tenant);
        return TenantAuthRecordAssembler.toVo(record);
    }

}
