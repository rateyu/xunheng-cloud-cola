package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.TenantAuthRecordSaveCmd;
import com.xunheng.system.client.dto.VO.TenantAuthRecordVO;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;
/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:39
 */
public class TenantAuthRecordAssembler {
    public static TenantAuthRecordEntity toSaveEntity(TenantAuthRecordSaveCmd cmd) {
        TenantAuthRecordEntity entity = new TenantAuthRecordEntity();
        entity.setId(cmd.getId());
        entity.setTenantId(cmd.getTenantId());
        entity.setAuthDate(cmd.getAuthDate());
        entity.setEndDate(cmd.getEndDate());
        return entity;
    }

    public static TenantAuthRecordVO toVo(TenantAuthRecordEntity entity) {
        if(entity == null)return null;
        TenantAuthRecordVO vo = new TenantAuthRecordVO();
        vo.setId(entity.getId());
        vo.setTenantId(entity.getTenantId());
        vo.setAuthDate(entity.getAuthDate());
        vo.setEndDate(entity.getEndDate());
        vo.setTenantName(entity.getTenantName());
        return vo;
    }
}
