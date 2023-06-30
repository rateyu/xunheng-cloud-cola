package com.xunheng.system.domain.user.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.domain.user.model.UserEntity;
import com.xunheng.system.client.dto.query.UserPageQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户网关
 * @author: hhqkkr
 * @date: 2023/6/30 00:18
 */
public interface UserGateway {

    /**
     * 根据部门获取用户
     * @param departmentId 部门id
     * @return 用户集合
     */
    List<UserEntity> getByDepartmentId(String departmentId);

    /**
     * 用户选择器
     * @return 用户集合
     */
    List<UserEntity> getSelectItem();

    /**
     * 用户分页列表
     * @param query 查询条件dto
     * @return 分页列表
     */
    IPage<UserEntity> pageList(UserPageQuery query);

    /**
     * 用户删除
     * @param id 用户id
     */
    void remove(String id);

    /**
     * 保存或更新用户信息
     * @param user 用户实体
     * @return 用户实体
     */
    UserEntity saveOrUpdate(UserEntity user);

    /**
     * 根据id获取用户信息
     * @param id 用户id
     * @return 用户实体
     */
    UserEntity getOneById(String id);

    /**
     * 根据用户名获取用户实体
     * @param username 用户名
     * @return 用户实体
     */
    UserEntity getOneByUsername(String username);

    /**
     * 根据手机号获取用户实体
     * @param mobile 手机号
     * @return 用户实体
     */
    UserEntity getOneByMobile(String mobile);

    /**
     * 根据邮箱获取用户实体
     * @param email 邮箱
     * @return 用户实体
     */
    UserEntity getOneByEmail(String email);

    /**
     * 根据上级获取全部下级
     * @param superior 上级id
     * @return 用户列表
     */
    List<UserEntity> getBySuperior(String superior);

    /**
     * 删除用户详情缓存
     * @param userId 用户id
     */
    void cleanUserDetailCache(String userId);
}
