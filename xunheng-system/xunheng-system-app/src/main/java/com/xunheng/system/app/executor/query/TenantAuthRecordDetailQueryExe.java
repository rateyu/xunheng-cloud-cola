package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.TenantAuthRecordAssembler;
import com.xunheng.system.client.dto.VO.TenantAuthRecordVO;
import com.xunheng.system.domain.tenant.gateway.TenantAuthRecordGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录详情查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:59
 */
@Component
public class TenantAuthRecordDetailQueryExe {

    @Resource
    TenantAuthRecordGateway tenantAuthRecordGateway;

    public TenantAuthRecordVO execute(String id) {
        return TenantAuthRecordAssembler.toVo(tenantAuthRecordGateway.getOneById(id));
    }
}
