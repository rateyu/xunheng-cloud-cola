package com.xunheng.auth.infrastructure.rpc;


import com.xunheng.base.constant.ServiceNameConstant;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.base.vo.system.UserLoginVO;
import com.xunheng.base.vo.system.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: system服务api
 * @author: hhqkkr
 * @create: 2021-12-28 17:56
 */
@FeignClient(contextId = "feignSystemServiceAuth",
        value = ServiceNameConstant.SYSTEM_SERVICE,
        path = "/system")
public interface FeignSystemService {

    /**
     * 租户是否过期
     * @param tenantId 租户id
     * @return 是否
     */
    @RequestMapping(value = "/isTenantExpire")
    Boolean isTenantExpire(@RequestParam(value = "tenantId") String tenantId);

    /**
     * 获取用于校验登录的用户信息
     * @param username 用户名
     * @return 用户信息
     */
    @RequestMapping(value = "/getUserLoginInfo")
    UserLoginVO getUserLoginInfo(@RequestParam(value = "username") String username);

    /**
     * 获取用户详情
     * @param username 用户名
     * @return 用户详情
     */
    @RequestMapping(value = "/getUserDetailByUsername")
    UserVO getUserDetailByUsername(@RequestParam(value = "username") String username);

    /**
     * 获取用户详情
     * @param userId 用户id
     * @return 用户详情
     */
    @RequestMapping(value = "/getUserDetailByUserId")
    UserVO getUserDetailByUserId(@RequestParam(value = "userId") String userId);

    /**
     * 刷新用户信息缓存
     * @param userId 用户id
     */
    @RequestMapping(value = "/reloadUserDetailCache")
    void reloadUserDetailCache(@RequestParam(value = "userId") String userId);
}
