package com.xunheng.system.domain.role.ability;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.query.RolePageQuery;
import com.xunheng.system.domain.role.model.RoleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色领域服务
 * @author: hhqkkr
 * @date: 2023/6/30 00:08
 */
public interface RoleDomainService {

    /**
     * 角色分页列表
     * @param query 查询条件
     */
    IPage<RoleEntity> pageList(RolePageQuery query);
}
