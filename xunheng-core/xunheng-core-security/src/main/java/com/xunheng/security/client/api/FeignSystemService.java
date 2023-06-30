package com.xunheng.security.client.api;


import com.xunheng.base.annotation.FeignAPI;
import com.xunheng.base.constant.ServiceNameConstant;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.base.vo.system.UserVO;
import io.swagger.annotations.ApiOperation;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: system服务api
 * @author: hhqkkr
 * @create: 2021-12-28 17:56
 */
@FeignClient(contextId = "feignSystemServiceSecurity",
        value = ServiceNameConstant.SYSTEM_SERVICE,
        path = "/system")
public interface FeignSystemService{

    /**
     * 用户权限码集合
     * @param id 用户id
     * @return 权限码集合
     */
    @RequestMapping(value = "/getUserPermissionCodes")
    List<String> getUserPermissionCodes(@RequestParam(value = "id") String id);

    /**
     * 获取用户详情
     * @param userId id
     * @return 用户详情
     */
    @RequestMapping(value = "/getUserDetailByUserId")
    UserVO getUserDetailByUserId(@RequestParam(value = "userId") String userId);

    /**
     * 根据用户与功能找到对应的角色集合
     * @param userId 用户id
     * @param code 权限码
     * @return 角色集合
     */
    @RequestMapping(value = "/getRoleByUserAndAction")
    List<RoleVO> getRoleByUserAndAction(@RequestParam(value = "userId") String userId, @RequestParam(value = "code") String code);

}
