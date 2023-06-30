package com.xunheng.system.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.UserLoginVO;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.client.dto.query.UserPageQuery;
import com.xunheng.system.client.dto.UserPasswordUpdateCmd;
import com.xunheng.system.client.dto.UserSystemCreateCmd;
import com.xunheng.system.client.dto.UserSystemUpdateCmd;
import com.xunheng.system.client.dto.UserUpdateCmd;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户信息service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:30
 */
public interface UserService {

    /**
     * 用户选择器
     * @return 用户列表
     */
    List<SelectItemVO> getSelectItem();

    /**
     * 用户分页信息
     * @param query 查询dto
     * @return 分页信息
     */
    IPage<UserVO> pageList(UserPageQuery query);

    /**
     * 系统创建用户
     * @param cmd 操作dto
     * @return 用户信息
     */
    UserVO systemCreate(UserSystemCreateCmd cmd);

    /**
     * 系统更新用户
     * @param cmd 操作dto
     * @return 用户信息
     */
    UserVO systemUpdate(UserSystemUpdateCmd cmd);

    /**
     * 重制密码
     * @param id 用户id
     */
    void resetPass(String id);

    /**
     * 更新用户
     * @param cmd 用户更新操作dto
     * @return 用户信息vo
     */
    UserVO update(UserUpdateCmd cmd);

    /**
     * 密码修改
     * @param cmd 操作dto
     */
    void passwordEdit(UserPasswordUpdateCmd cmd);

    /**
     * 用户禁用
     * @param userId 用户id
     */
    void disable(String userId);

    /**
     * 用户启用
     * @param userId 用户id
     */
    void enable(String userId);

    /**
     * 根据token获取用户信息
     * @param token token
     * @return 用户信息vo
     */
    UserVO getUserInfoByToken(String token);

    /**
     * 删除用户
     * @param id 用户id
     */
    void remove(String id);

    /**
     * 获取用户权限码合集
     * @param userId 用户id
     * @return 权限码合集
     */
    List<String> getUserPermissionCodes(String userId);

    /**
     * 获取用户详情
     * @param username 用户名
     * @return 用户详情
     */
    UserVO getUserDetailByUsername(String username);

    /**
     * 获取用户详情
     * @param userId 用户id
     * @return 用户详情
     */
    UserVO getUserDetailByUserId(String userId);

    /**
     * 获取用户登录校验信息
     * @param username 用户名
     * @return 用户信息
     */
    UserLoginVO getUserLoginInfo(String username);

    /**
     * 刷新用户缓存
     * @param userId 用户id
     */
    void reloadUserDetailCache(String userId);
}
