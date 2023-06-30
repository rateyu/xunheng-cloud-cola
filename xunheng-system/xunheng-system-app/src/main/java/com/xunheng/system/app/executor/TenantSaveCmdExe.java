
package com.xunheng.system.app.executor;

import com.xunheng.system.app.assembler.TenantAssembler;
import com.xunheng.system.client.dto.TenantSaveCmd;
import com.xunheng.system.client.dto.VO.TenantVO;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户保存处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:30
 */
@Component
public class TenantSaveCmdExe {

    @Resource
    private TenantGateway tenantGateway;

    public TenantVO execute(TenantSaveCmd cmd) {
        return TenantAssembler.toVo(tenantGateway.saveOrUpdate(TenantAssembler.toSaveEntity(cmd)));
    }

}
