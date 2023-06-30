package com.xunheng.system.domain.customConfig.gateway;

import com.xunheng.system.client.dto.query.CustomConfigQuery;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 个性化配置网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:41
 */
public interface CustomConfigGateway {

    /**
     * 保存或更新个性化配置
     * @param entity 个性化配置实体
     * @return 个性化配置实体
     */
    CustomConfigEntity saveOrUpdate(CustomConfigEntity entity);

    /**
     * 获取一个个性化配置
     * @param query 查询条件
     * @return 个性化配置
     */
    CustomConfigEntity getOne(CustomConfigQuery query);

    /**
     * 获取系统拓展配置列表
     * @return 配置列表
     */
    List<CustomConfigEntity> getSystemConfigList();

    /**
     * 获取用户的个性化配置列表
     * @param userId 用户id
     * @return 配置列表
     */
    List<CustomConfigEntity> getPersonalConfigsByUserId(String userId);

    /**
     * 删除配置
     * @param id 配置id
     */
    void remove(String id);

    /**
     * 保存个性化配置
     * @param entity 个性化配置实体
     * @return 个性化配置实体
     */
    CustomConfigEntity savePersonalConfig(CustomConfigEntity entity);
}
