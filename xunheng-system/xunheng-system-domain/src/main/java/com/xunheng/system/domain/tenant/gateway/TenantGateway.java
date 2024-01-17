package com.xunheng.system.domain.tenant.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.domain.tenant.model.TenantEntity;
import com.xunheng.system.client.dto.query.TenantPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户网关
 * @author: hhqkkr
 * @date: 2023/6/30 00:12
 */
public interface TenantGateway {

    /**
     * 租户分页列表
     * @param query 查询条件dto
     * @return 分页列表
     */
    IPage<TenantEntity> pageList(TenantPageQuery query);

    /**
     * 根据id获取租户信息
     * @param id 租户id
     * @return 租户实体
     */
    TenantEntity getOneById(String id);

    /**
     * 保存或更新租户实体
     * @param entity 租户实体
     * @return 租户实体
     */
    TenantEntity saveOrUpdate(TenantEntity entity);

    /**
     * 删除租户
     * @param id 租户id
     */
    void remove(String id);

    /**
     * 租户是否过期
     * @param tenantId 租户id
     * @return 是否
     */
    Boolean isTenantExpire(String tenantId);

}
