package com.xunheng.system.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.api.TenantAuthRecordService;
import com.xunheng.system.client.dto.query.TenantAuthRecordPageQuery;
import com.xunheng.system.client.dto.TenantAuthRecordSaveCmd;
import com.xunheng.system.client.dto.VO.TenantAuthRecordVO;
import com.xunheng.system.app.executor.TenantAuthRecordRemoveCmdExe;
import com.xunheng.system.app.executor.TenantAuthRecordSaveCmdExe;
import com.xunheng.system.app.executor.query.TenantAuthRecordDetailQueryExe;
import com.xunheng.system.app.executor.query.TenantAuthRecordPageQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class TenantAuthRecordServiceImpl implements TenantAuthRecordService {

    @Resource
    private TenantAuthRecordPageQueryExe tenantAuthRecordPageQueryExe;

    @Resource
    private TenantAuthRecordDetailQueryExe tenantAuthRecordDetailQueryExe;

    @Resource
    TenantAuthRecordSaveCmdExe tenantAuthRecordSaveCmdExe;

    @Resource
    TenantAuthRecordRemoveCmdExe tenantAuthRecordRemoveCmdExe;

    @Override
    public IPage<TenantAuthRecordVO> pageList(TenantAuthRecordPageQuery query) {
        return tenantAuthRecordPageQueryExe.execute(query);
    }

    @Override
    public TenantAuthRecordVO getDetail(String id) {
        return tenantAuthRecordDetailQueryExe.execute(id);
    }

    @Override
    public TenantAuthRecordVO saveOrUpdate(TenantAuthRecordSaveCmd cmd) {
        return tenantAuthRecordSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        tenantAuthRecordRemoveCmdExe.execute(id);
    }
}