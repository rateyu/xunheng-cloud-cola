package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.User;
import com.xunheng.system.client.dto.query.UserPageQuery;
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
public interface UserMapper extends BaseMapper<User> {

    IPage<User> pageList(Page<User> page, @Param("qry") UserPageQuery qry);


}
