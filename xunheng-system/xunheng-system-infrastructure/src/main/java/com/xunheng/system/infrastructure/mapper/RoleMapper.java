package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.Role;
import com.xunheng.system.client.dto.query.RolePageQuery;
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
public interface RoleMapper extends BaseMapper<Role> {

    List<Role> getAll();

    IPage<Role> pageList(Page<Role> page, @Param("qry") RolePageQuery query);

    List<Role> getRoleByUserAndAction(@Param("userId") String userId, @Param("code") String permissionCode);
}
