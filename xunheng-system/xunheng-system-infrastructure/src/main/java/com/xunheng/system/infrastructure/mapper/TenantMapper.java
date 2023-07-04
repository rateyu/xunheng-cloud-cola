package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.Tenant;
import com.xunheng.system.client.dto.query.TenantPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description:租户mapper
 * @author: hhqkkr
 * @create: 2021-12-13 18:41
 */
@Repository
public interface TenantMapper extends BaseMapper<Tenant> {

    /**
     * 获取租户分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<Tenant> pageList(Page<Tenant> page, @Param("qry") TenantPageQuery query);
}
