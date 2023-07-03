package com.xunheng.generator.domain.genConfig.gateway;

import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器网关
 * @author: hhqkkr
 * @date: 2023/7/3 17:20
 */
public interface GenConfigGateway {

    /**
     * 获取生成器表格配置
     * @return 配置
     */
    GenConfigEntity getConfig();

    /**
     * 保存配置
     * @param saveEntity 配置实体
     */
    void save(GenConfigEntity saveEntity);
}
