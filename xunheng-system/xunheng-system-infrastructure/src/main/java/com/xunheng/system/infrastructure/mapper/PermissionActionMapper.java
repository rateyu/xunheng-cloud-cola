package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunheng.system.infrastructure.DO.PermissionAction;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description:权限功能库mapper
 * @author: hhqkkr
 * @create: 2021-12-13 18:41
 */
@Repository
public interface PermissionActionMapper extends BaseMapper<PermissionAction> {

    /**
     * 根据权限id获取权限功能列表
     * @param permissionId 权限id
     * @return 权限功能列表
     */
    List<PermissionAction> getByPermissionId(@Param("permissionId") String permissionId);

    /**
     * 根据用户id获取权限功能集合
     * @param userId 用户id
     * @return 权限功能集合
     */
    List<String> getCodesByUserId(String userId);
}
