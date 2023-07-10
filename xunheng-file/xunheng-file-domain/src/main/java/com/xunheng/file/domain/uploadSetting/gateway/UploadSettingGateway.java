package com.xunheng.file.domain.uploadSetting.gateway;


import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置网关
 * @author: hhqkkr
 * @date: 2023/7/10 13:16
 */
public interface UploadSettingGateway {

    /**
     * 上传设置分页列表
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<UploadSettingEntity> pageList(UploadSettingPageQuery query);

    /**
     * 插入或更新上传设置
     * @param entity 上传设置信息
     * @return 上传设置信息
     */
    UploadSettingEntity saveOrUpdate(UploadSettingEntity entity);

    /**
     * 删除上传设置
     * @param id 上传设置id
     */
    void remove(String id);

    /**
     * 根据code找到对应上传设置
     * @param code 上传码
     * @return 上传设置信息
     */
    UploadSettingEntity getByCode(String code);
}
