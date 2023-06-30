package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunheng.system.infrastructure.DO.Permission;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description:
 * @author: hhqkkr
 * @create: 2021-12-13 18:41
 */
@Repository
public interface PermissionMapper extends BaseMapper<Permission> {

    /**
     * 根据用户获取用户权限
     * @param userId 用户id
     * @param isSuperAdmin 是否是超级管理员
     * @return 用户权限
     */
    List<Permission> getUserPermissionList(@Param("userId") String userId,@Param("isSuperAdmin")Boolean isSuperAdmin);

    /**
     * 获取系统页面权限列表
     * @return 权限列表
     */
    List<Permission> getSystemPermissionList();

}
