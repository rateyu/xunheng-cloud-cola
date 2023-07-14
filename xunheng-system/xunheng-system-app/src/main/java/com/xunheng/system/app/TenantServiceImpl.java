package com.xunheng.system.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.api.TenantService;
import com.xunheng.system.client.dto.query.TenantPageQuery;
import com.xunheng.system.client.dto.TenantSaveCmd;
import com.xunheng.system.client.dto.VO.TenantVO;
import com.xunheng.system.app.executor.TenantRemoveCmdExe;
import com.xunheng.system.app.executor.TenantSaveCmdExe;
import com.xunheng.system.app.executor.query.TenantDetailQueryExe;
import com.xunheng.system.app.executor.query.TenantExpireQueryExe;
import com.xunheng.system.app.executor.query.TenantPageQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class TenantServiceImpl implements TenantService {

    @Resource
    private TenantPageQueryExe tenantPageQueryExe;

    @Resource
    private TenantDetailQueryExe tenantDetailQueryExe;

    @Resource
    private TenantSaveCmdExe tenantSaveCmdExe;

    @Resource
    private TenantRemoveCmdExe tenantRemoveCmdExe;

    @Resource
    private TenantExpireQueryExe tenantExpireQueryExe;

    @Override
    public IPage<TenantVO> pageList(TenantPageQuery query){
        return tenantPageQueryExe.execute(query);
    }

    @Override
    public TenantVO getDetail(String id) {
        return tenantDetailQueryExe.execute(id);
    }

    @Override
    public TenantVO saveOrUpdate(TenantSaveCmd cmd) {
        return tenantSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        tenantRemoveCmdExe.execute(id);
    }

    @Override
    public Boolean isTenantExpire(String tenantId) {
        return tenantExpireQueryExe.execute(tenantId);
    }

}