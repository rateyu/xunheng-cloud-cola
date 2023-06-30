package com.xunheng.system.infrastructure.gateway.impl;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.base.constant.SaSessionConstant;
import com.xunheng.system.infrastructure.DO.User;
import com.xunheng.system.infrastructure.convertor.UserConvertor;
import com.xunheng.system.client.dto.query.UserPageQuery;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.infrastructure.mapper.UserMapper;
import com.xunheng.system.domain.user.model.UserEntity;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:42
 */
@Slf4j
@Component
public class UserGatewayImpl implements UserGateway {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<UserEntity> getByDepartmentId(String departmentId) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("department_id",departmentId);
        List<User> list = userMapper.selectList(wrapper);
        return list.stream().map(UserConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<UserEntity> getSelectItem() {
        return userMapper.selectList(new QueryWrapper<>()).stream()
                .map(UserConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public IPage<UserEntity> pageList(UserPageQuery query) {
        IPage<User> page = userMapper.pageList(new Page<User>(query.getPage(), query.getPageSize()), query);
        return page.convert(UserConvertor::toEntity);
    }

    @Override
    public void remove(String id) {
        userMapper.deleteById(id);
    }

    @Override
    public UserEntity saveOrUpdate(UserEntity entity) {
        User user = UserConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(user.getId()) ? userMapper.insert(user) : userMapper.updateById(user);
        return UserConvertor.toEntity(user);
    }

    @Override
    public UserEntity getOneById(String id) {
        User user = userMapper.selectById(id);
        return UserConvertor.toEntity(user);
    }

    @Override
    public UserEntity getOneByUsername(String username) {
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username",username);
        User user = userMapper.selectOne(wrapper);
        return UserConvertor.toEntity(user);
    }

    @Override
    public UserEntity getOneByMobile(String mobile) {
        if(StringUtils.isNullOrEmpty(mobile))return null;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("mobile",mobile);
        User user = userMapper.selectOne(wrapper);
        return UserConvertor.toEntity(user);
    }

    @Override
    public UserEntity getOneByEmail(String email) {
        if(StringUtils.isNullOrEmpty(email))return null;
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("email",email);
        User user = userMapper.selectOne(wrapper);
        return UserConvertor.toEntity(user);
    }

    @Override
    public List<UserEntity> getBySuperior(String superior) {
        if(StringUtils.isNullOrEmpty(superior))return new ArrayList<UserEntity>();
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("superior",superior);
        List<User> list = userMapper.selectList(wrapper);
        return list.stream().map(UserConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void cleanUserDetailCache(String userId) {
        SaSession userSession = StpUtil.getSessionByLoginId(userId);
        if(userSession == null)return;
        userSession.delete(SaSessionConstant.USER_INFO_KEY);
    }
}
