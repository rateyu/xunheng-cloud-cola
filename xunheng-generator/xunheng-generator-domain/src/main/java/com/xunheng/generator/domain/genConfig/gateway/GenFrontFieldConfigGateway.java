package com.xunheng.generator.domain.genConfig.gateway;

import com.xunheng.generator.domain.genConfig.model.GenFrontFieldConfigEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器前端字段配置网关
 * @author: hhqkkr
 * @date: 2023/7/3 17:20
 */
public interface GenFrontFieldConfigGateway {

    /**
     * 删除所有字段配置
     */
    void removeAllFields();

    /**
     * 批量创建
     * @param fieldList 字段列表
     */
    void batchCreate(List<GenFrontFieldConfigEntity> fieldList);

    /**
     * 获取所有字段配置
     * @return 字段配置列表
     */
    List<GenFrontFieldConfigEntity> listAll();
}
