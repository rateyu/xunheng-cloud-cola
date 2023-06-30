package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.DictData;
import com.xunheng.system.client.dto.query.DictDataPageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description:
 * @author: hhqkkr
 * @create: 2021-12-13 18:41
 */
@Repository
public interface DictDataMapper extends BaseMapper<DictData> {

    /**
     * 字典数据分页列表
     * @param page 分页信息
     * @param query 查询条件
     * @return 分页列表
     */
    IPage<DictData> pageList(Page<DictData> page, @Param("qry") DictDataPageQuery query);
}
