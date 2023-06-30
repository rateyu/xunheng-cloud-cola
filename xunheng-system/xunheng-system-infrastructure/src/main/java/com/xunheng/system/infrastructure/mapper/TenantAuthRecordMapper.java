package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.TenantAuthRecord;
import com.xunheng.system.client.dto.query.TenantAuthRecordPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description:租户授权mapper
 * @author: hhqkkr
 * @create: 2021-12-13 18:41
 */
@Repository
public interface TenantAuthRecordMapper extends BaseMapper<TenantAuthRecord> {
    IPage<TenantAuthRecord> pageList(Page<TenantAuthRecord> page, @Param("qry") TenantAuthRecordPageQuery query);
}
