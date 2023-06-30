package com.xunheng.system.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.system.client.dto.query.RolePageQuery;
import com.xunheng.system.client.dto.RolePermEditCmd;
import com.xunheng.system.client.dto.RoleSaveCmd;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:20
 */
public interface RoleService {

    /**
     * 角色选择器
     * @return 角色列表
     */
    List<SelectItemVO> getSelectItem();

    /**
     * 角色分页列表
     * @param query 查询dto
     * @return 分页列表
     */
    IPage<RoleVO> pageList(RolePageQuery query);

    /**
     * 获取所有角色列表
     * @return 角色列表
     */
    List<RoleVO> getAll();

    /**
     * 配置角色权限
     * @param cmd 配置操作dto
     */
    void editRolePerm(RolePermEditCmd cmd);

    /**
     * 保存或更新角色信息
     * @param cmd 保存操作dto
     * @return 角色vo
     */
    RoleVO saveOrUpdate(RoleSaveCmd cmd);

    /**
     * 删除
     * @param id 角色id
     */
    void remove(String id);

    /**
     * 根据用户与操作码获取角色集合
     * @param userId 用户信息
     * @param code 功能操作码
     * @return 角色集合
     */
    List<RoleVO> getRoleByUserAndAction(String userId, String code);
}