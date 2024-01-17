package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.Role;
import com.xunheng.system.infrastructure.convertor.RoleConvertor;
import com.xunheng.system.client.dto.query.RolePageQuery;
import com.xunheng.system.domain.role.gateway.RoleGateway;
import com.xunheng.system.infrastructure.convertor.UserConvertor;
import com.xunheng.system.infrastructure.mapper.RoleMapper;
import com.xunheng.system.domain.role.model.RoleEntity;
import io.seata.common.util.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:46
 */
@Component
public class RoleGatewayImpl implements RoleGateway {

    @Resource
    RoleMapper roleMapper;

    @Override
    public IPage<RoleEntity> pageList(RolePageQuery query) {
        IPage<Role> page = roleMapper.pageList(new Page<Role>(query.getPage(), query.getPageSize()), query);
        return page.convert(RoleConvertor::toEntity);
    }

    @Override
    public List<RoleEntity> getAll() {
        List<Role> list = roleMapper.getAll();
        return list.stream().map(RoleConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public RoleEntity saveOrUpdate(RoleEntity entity) {
        Role role = RoleConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(role.getId()) ? roleMapper.insert(role) : roleMapper.updateById(role);
        return RoleConvertor.toEntity(role);
    }

    @Override
    public void remove(String id) {
        roleMapper.deleteById(id);
    }

    @Override
    public RoleEntity getById(String id) {
        Role role = roleMapper.selectById(id);
        return RoleConvertor.toEntity(role);
    }

    @Override
    public List<RoleEntity> getRoleByUserAndAction(String userId, String code) {
        List<Role> list = roleMapper.getRoleByUserAndAction(userId, code);
        return list.stream().map(RoleConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<RoleEntity> getSelectItem() {
        return roleMapper.selectList(new QueryWrapper<>()).stream()
                .map(RoleConvertor::toEntity).collect(Collectors.toList());
    }
}
