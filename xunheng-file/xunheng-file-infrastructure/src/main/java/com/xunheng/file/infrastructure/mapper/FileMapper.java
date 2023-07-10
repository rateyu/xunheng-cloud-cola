package com.xunheng.file.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.file.client.dto.query.FilePageQuery;
import com.xunheng.file.infrastructure.DO.File;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件数据层
 * @author: hhqkkr
 * @date: 2023/7/10 12:05
 */
@Repository
public interface FileMapper extends BaseMapper<File> {

    /**
     * 文件分页
     * @param page 分页设置
     * @param query 搜索条件
     * @return 分页列表
     */
    IPage<File> pageList(Page<File> page, @Param("qry")FilePageQuery query);

}
