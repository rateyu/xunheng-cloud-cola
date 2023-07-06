package com.xunheng.generator.domain.genConfig.ability;

import com.xunheng.generator.domain.genConfig.model.FrontCodeEntity;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成器领域服务
 * @author: hhqkkr
 * @date: 2023/7/3 17:26
 */
public interface GenConfigDomainService {

    /**
     * 保存并生成代码
     * @param entity 配置实体
     */
    void saveAndGen(GenConfigEntity entity);

    /**
     * 保存并生成前端代码
     * @param entity 配置实体
     */
    FrontCodeEntity saveAndGenFront(GenConfigEntity entity);

    /**
     * 保存代码
     * @param entity 配置实体
     */
    void save(GenConfigEntity entity);


}
