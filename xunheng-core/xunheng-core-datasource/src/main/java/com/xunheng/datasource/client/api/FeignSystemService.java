package com.xunheng.datasource.client.api;


import com.xunheng.base.constant.ServiceNameConstant;
import com.xunheng.base.vo.system.UserVO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @program: xunheng-cloud-cola
 * @description: system服务api
 * @author: hhqkkr
 * @create: 2021-12-28 17:56
 */
@FeignClient(contextId = "feignSystemServiceDatasource",
        value = ServiceNameConstant.SYSTEM_SERVICE,
        path = "/system")
public interface FeignSystemService
{

    /**
     * 获取用户详情
     * @param userId 用户id
     * @return 用户详情
     */
    @RequestMapping(value = "/getUserDetailByUserId")
    UserVO getUserDetailByUserId(@RequestParam(value = "userId") String userId);

}
