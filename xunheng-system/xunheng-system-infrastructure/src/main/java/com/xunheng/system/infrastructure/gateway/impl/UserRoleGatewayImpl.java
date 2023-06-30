package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.UserRole;
import com.xunheng.system.infrastructure.convertor.UserRoleConvertor;
import com.xunheng.system.domain.user.gateway.UserRoleGateway;
import com.xunheng.system.infrastructure.mapper.UserRoleMapper;
import com.xunheng.system.domain.user.model.UserRoleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户角色网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:41
 */
@Slf4j
@Component
public class UserRoleGatewayImpl implements UserRoleGateway {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public List<UserRoleEntity> getByRoleId(String roleId) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("role_id",roleId);
        List<UserRole> list = userRoleMapper.selectList(wrapper);
        return list.stream().map(UserRoleConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void removeByUserId(String userId) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        userRoleMapper.delete(wrapper);
    }

    @Override
    public List<UserRoleEntity> getByUserId(String userId) {
        QueryWrapper<UserRole> wrapper = new QueryWrapper<>();
        wrapper.eq("user_id",userId);
        List<UserRole> list = userRoleMapper.selectList(wrapper);
        return list.stream().map(UserRoleConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void create(String userId, String roleId) {
        UserRole ur = new UserRole();
        ur.setRoleId(roleId);
        ur.setUserId(userId);
        userRoleMapper.insert(ur);
    }
}
