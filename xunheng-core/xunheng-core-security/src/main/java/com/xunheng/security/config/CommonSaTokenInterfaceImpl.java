package com.xunheng.security.config;

import cn.dev33.satoken.stp.StpInterface;
import com.xunheng.base.vo.system.UserRoleVO;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.security.client.api.FeignSystemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description:自定义权限验证接口扩展
 * @author: hhqkkr
 * @create: 2021-12-15 15:44
 */
@Component
public class CommonSaTokenInterfaceImpl implements StpInterface {

    @Resource
    private FeignSystemService feignSystemService;

    /**
     * 返回一个账号所拥有的权限码集合
     */
    @Override
    public List<String> getPermissionList(Object loginId, String loginType) {
        return feignSystemService.getUserPermissionCodes(loginId.toString());
    }

    /**
     * 返回一个账号所拥有的角色标识集合 (权限与角色可分开校验)
     */
    @Override
    public List<String> getRoleList(Object loginId, String loginType) {
        UserVO user = feignSystemService.getUserDetailByUserId(loginId.toString());
        if(user == null)return null;
        List<String> roleNames = new ArrayList<>();
        for (UserRoleVO role : user.getRoles()) {
            roleNames.add(role.getRoleName());
        }
        return roleNames;
    }
}
