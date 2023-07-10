package com.xunheng.file.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;
import com.xunheng.file.infrastructure.DO.UploadSetting;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置数据层
 * @author: hhqkkr
 * @date: 2023/7/10 12:07
 */
@Repository
public interface UploadSettingMapper extends BaseMapper<UploadSetting> {

    /**
     * 上传设置分页
     * @param page 分页信息
     * @param query 查询条件
     * @return 分页列表
     */
    IPage<UploadSetting> pageList(Page<UploadSetting> page, @Param("qry") UploadSettingPageQuery query);

}
