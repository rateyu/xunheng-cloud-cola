package com.xunheng.system.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.UserLoginVO;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.executor.*;
import com.xunheng.system.app.executor.query.*;
import com.xunheng.system.client.api.UserService;
import com.xunheng.system.client.dto.UserPasswordUpdateCmd;
import com.xunheng.system.client.dto.UserSystemCreateCmd;
import com.xunheng.system.client.dto.UserSystemUpdateCmd;
import com.xunheng.system.client.dto.UserUpdateCmd;
import com.xunheng.system.client.dto.query.UserPageQuery;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.stereotype.Service;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class UserServiceImpl implements UserService {

    @Resource
    private UserSelectItemQueryExe userSelectItemQueryExe;

    @Resource
    private UserPageQueryExe userPageQueryExe;

    @Resource
    private UserSystemCreateCmdExe userSystemSaveCmdExe;

    @Resource
    private UserSystemUpdateCmdExe userSystemUpdateCmdExe;

    @Resource
    private UserResetPassCmdExe userResetPassCmdExe;

    @Resource
    private UserUpdateCmdExe userUpdateCmdExe;

    @Resource
    private UserPasswordUpdateCmdExe userPasswordUpdateCmdExe;

    @Resource
    private UserStatusChangeCmdExe userStatusChangeCmdExe;

    @Resource
    private UserInfoByTokenQueryExe userInfoByTokenQueryExe;

    @Resource
    private UserRemoveCmdExe userRemoveCmdExe;

    @Resource
    private UserPermissionCodeQueryExe userPermissionCodeQueryExe;

    @Resource
    private UserDetailByUsernameQueryExe userDetailByUsernameQueryExe;

    @Resource
    private UserDetailByUserIdQueryExe userDetailByUserIdQueryExe;

    @Resource
    private UserLoginInfoQueryExe userLoginInfoQueryExe;

    @Resource
    private UserDetailCacheReloadCmdExe userDetailCacheReloadCmdExe;

    @Override
    public List<SelectItemVO> getSelectItem() {
        return userSelectItemQueryExe.execute();
    }

    @Override
    public IPage<UserVO> pageList(UserPageQuery query) {
        return userPageQueryExe.execute(query);
    }

    @Override
    public UserVO systemCreate(UserSystemCreateCmd cmd) {
        return userSystemSaveCmdExe.execute(cmd);
    }

    @Override
    public UserVO systemUpdate(UserSystemUpdateCmd cmd) {
        return userSystemUpdateCmdExe.execute(cmd);
    }

    @Override
    public UserVO update(UserUpdateCmd cmd) {
        return userUpdateCmdExe.execute(cmd);
    }

    @Override
    public void resetPass(String id) {
         userResetPassCmdExe.execute(id);
    }

    @Override
    public void passwordEdit(UserPasswordUpdateCmd cmd) {
        userPasswordUpdateCmdExe.execute(cmd);
    }

    @Override
    public void disable(String userId) {
        userStatusChangeCmdExe.execute(userId,false);
    }

    @Override
    public void enable(String userId) {
        userStatusChangeCmdExe.execute(userId,true);
    }

    @Override
    public UserVO getUserInfoByToken(String token) {
        return userInfoByTokenQueryExe.execute(token);
    }

    @Override
    public void remove(String id) {
        userRemoveCmdExe.execute(id);
    }

    @Override
    public List<String> getUserPermissionCodes(String userId) {
        return userPermissionCodeQueryExe.execute(userId);
    }

    @Override
    public UserVO getUserDetailByUsername(String username) {
        return userDetailByUsernameQueryExe.execute(username);
    }

    @Override
    public UserVO getUserDetailByUserId(String userId) {
        return userDetailByUserIdQueryExe.execute(userId);
    }

    @Override
    public UserLoginVO getUserLoginInfo(String username) {
        return userLoginInfoQueryExe.execute(username);
    }

    @Override
    public void reloadUserDetailCache(String userId) {
        userDetailCacheReloadCmdExe.execute(userId);
    }
}