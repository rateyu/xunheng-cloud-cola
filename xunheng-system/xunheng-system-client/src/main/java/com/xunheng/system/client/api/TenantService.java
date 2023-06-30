package com.xunheng.system.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.TenantSaveCmd;
import com.xunheng.system.client.dto.VO.TenantVO;
import com.xunheng.system.client.dto.query.TenantPageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: 租户service
 * @author: hhqkkr
 * @date: 2023/6/29 19:28
 */
public interface TenantService{

    /**
     * 租户分页列表
     * @param query 查询dto
     * @return 分页信息
     */
    IPage<TenantVO> pageList(TenantPageQuery query);

    /**
     * 获取详情
     * @param id 租户id
     * @return 租户信息
     */
    TenantVO getDetail(String id);

    /**
     * 保存或更新租户信息
     * @param cmd 保存操作cmd
     * @return 租户vo
     */
    TenantVO saveOrUpdate(TenantSaveCmd cmd);

    /**
     * 删除
     * @param id 租户id
     */
    void remove(String id);

    /**
     * 租户是否过去
     * @param tenantId 租户id
     * @return 是否
     */
    Boolean isTenantExpire(String tenantId);

}