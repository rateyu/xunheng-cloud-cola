package com.xunheng.system.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.app.assembler.TenantAssembler;
import com.xunheng.system.client.dto.query.TenantPageQuery;
import com.xunheng.system.client.dto.VO.TenantVO;
import com.xunheng.system.domain.tenant.gateway.TenantGateway;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户分页查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:02
 */
@Component
public class TenantPageQueryExe {

    @Resource
    TenantGateway tenantGateway;

    public IPage<TenantVO> execute(TenantPageQuery query) {
        IPage<TenantEntity> page = tenantGateway.pageList(query);
        return page.convert(TenantAssembler::toVo);
    }
}
