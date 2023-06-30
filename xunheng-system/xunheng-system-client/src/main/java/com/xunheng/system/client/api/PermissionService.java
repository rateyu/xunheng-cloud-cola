package com.xunheng.system.client.api;

import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.system.client.dto.PermissionCreateCmd;
import com.xunheng.system.client.dto.PermissionUpdateCmd;
import com.xunheng.system.client.dto.VO.UserPermissionVO;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:19
 */
public interface PermissionService {

    /**
     * 获取当前用户权限
     * @return 用户权限vo
     */
    UserPermissionVO getUserPermission();

    /**
     * 获取所有权限
     * @return 权限列表
     */
    List<PermissionVO> getSystemPermissionList();

    /**
     * 新增权限
     * @param cmd 保存操作dto
     * @return 权限vo
     */
    PermissionVO create(PermissionCreateCmd cmd);

    /**
     * 更新权限
     * @param cmd 保存操作dto
     * @return 权限vo
     */
    PermissionVO update(PermissionUpdateCmd cmd);

    /**
     * 删除权限
     * @param id 权限id
     */
    void remove(String id);
}