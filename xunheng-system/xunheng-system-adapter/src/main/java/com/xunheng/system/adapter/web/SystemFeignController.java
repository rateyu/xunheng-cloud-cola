package com.xunheng.system.adapter.web;

import com.xunheng.base.annotation.FeignAPI;
import com.xunheng.base.annotation.ResponseNotIntercept;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.base.vo.system.UserLoginVO;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.client.api.RoleService;
import com.xunheng.system.client.api.TenantService;
import com.xunheng.system.client.api.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;


@Api("system模块api")
@RestController
@RequestMapping("/system")
@ResponseNotIntercept//不被统一返回处理拦截
public class SystemFeignController {

    @Resource
    private UserService userService;

    @Resource
    private TenantService tenantService;

    @Resource
    private RoleService roleService;

    @FeignAPI
    @RequestMapping(value = "/isTenantExpire")
    @ApiOperation(value = "租户是否过期")
    public Boolean isTenantExpire(@RequestParam String tenantId){
        return tenantService.isTenantExpire(tenantId);
    }

    @FeignAPI
    @RequestMapping(value = "/getUserLoginInfo")
    @ApiOperation(value = "获取用户登录校验信息")
    public UserLoginVO getUserLoginInfo(@RequestParam String username){
        return userService.getUserLoginInfo(username);
    }

    @FeignAPI
    @RequestMapping(value = "/getUserDetailByUsername")
    @ApiOperation(value = "通过用户名获取用户详情")
    public UserVO getUserDetailByUsername(@RequestParam String username){
        return userService.getUserDetailByUsername(username);
    }

    @FeignAPI
    @RequestMapping(value = "/getUserDetailByUserId")
    @ApiOperation(value = "通过id获取用户详情")
    public UserVO getUserDetailByUserId(@RequestParam String userId){
        return userService.getUserDetailByUserId(userId);
    }

    @FeignAPI
    @RequestMapping(value = "/reloadUserDetailCache")
    @ApiOperation(value = "刷新用户信息缓存")
    void reloadUserDetailCache(@RequestParam(value = "userId") String userId){
        userService.reloadUserDetailCache(userId);
    }

    @FeignAPI
    @RequestMapping(value = "/getUserPermissionCodes")
    @ApiOperation(value = "找到当前id用户的所有api权限码")
    public List<String> getUserPermissionCodes(@RequestParam(value = "id") String id) {
        return userService.getUserPermissionCodes(id);
    }

    @FeignAPI
    @RequestMapping(value = "/getRoleByUserAndAction")
    @ApiOperation(value = "根据用户与权限码找到对应的角色信息")
    public List<RoleVO> getRoleByUserAndAction(@RequestParam(value = "userId") String userId, @RequestParam(value = "code") String code) {
        return roleService.getRoleByUserAndAction(userId, code);
    }


}
