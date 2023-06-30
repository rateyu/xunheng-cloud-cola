package com.xunheng.system.domain.role.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.domain.role.model.RoleEntity;
import com.xunheng.system.client.dto.query.RolePageQuery;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色网关
 * @author: hhqkkr
 * @date: 2023/6/30 00:03
 */
public interface RoleGateway {

    /**
     * 角色分页列表
     * @param query 查询条件
     * @return 分页列表
     */
    IPage<RoleEntity> pageList(RolePageQuery query);

    /**
     * 获取所有角色列表你
     * @return 角色列表
     */
    List<RoleEntity> getAll();

    /**
     * 保存或更新角色
     * @param entity 角色实体
     * @return 角色实体
     */
    RoleEntity saveOrUpdate(RoleEntity entity);

    /**
     * 删除角色
     * @param id 角色id
     */
    void remove(String id);

    /**
     * 根据id获取角色
     * @param id 角色id
     * @return 角色实体
     */
    RoleEntity getById(String id);

    /**
     * 根据用户与权限功能获取角色集合
     * @param userId 用户id
     * @param code 权限码
     * @return 角色集合
     */
    List<RoleEntity> getRoleByUserAndAction(String userId, String code);

    /**
     * 角色选择器
     * @return 角色列表
     */
    List<RoleEntity> getSelectItem();
}
