package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunheng.base.vo.system.UserRoleVO;
import com.xunheng.system.infrastructure.DO.UserRole;
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
public interface UserRoleMapper extends BaseMapper<UserRole> {

}
