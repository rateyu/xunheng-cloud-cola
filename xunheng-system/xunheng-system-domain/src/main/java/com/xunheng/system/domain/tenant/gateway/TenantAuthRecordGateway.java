package com.xunheng.system.domain.tenant.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.query.TenantAuthRecordPageQuery;
import com.xunheng.system.domain.tenant.model.TenantAuthRecordEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户授权记录网关
 * @author: hhqkkr
 * @date: 2023/6/30 00:14
 */
public interface TenantAuthRecordGateway {

    /**
     * 租户授权记录分页列表
     * @param query 查询条件dto
     * @return 分页列表
     */
    IPage<TenantAuthRecordEntity> pageList(TenantAuthRecordPageQuery query);

    /**
     * 根据id获取租户授权记录
     * @param id 记录id
     * @return 租户授权记录
     */
    TenantAuthRecordEntity getOneById(String id);

    /**
     * 保存或更新租户授权记录
     * @param entity 授权记录实体
     * @return 授权记录实体
     */
    TenantAuthRecordEntity saveOrUpdate(TenantAuthRecordEntity entity);

    /**
     * 删除授权记录
     * @param id 记录id
     */
    void remove(String id);

    /**
     * 获取最近的一次的租户授权记录
     * @param id 租户id
     * @return 授权记录实体
     */
    TenantAuthRecordEntity getLatestEndDate(String id);

}
