package com.xunheng.log.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.log.client.api.FeignSystemService;
import com.xunheng.log.client.dto.LogCreateCmd;
import com.xunheng.log.client.api.BaseFeignLogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 异步保存日志操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 17:11
 */
@Slf4j
@Component
public class AsyncLogSaveCmdExe
{
    @Resource
    BaseFeignLogService baseFeignLogService;

    @Resource
    FeignSystemService feignSystemService;

    @Async
    public void execute(LogCreateCmd cmd){
        log.info(cmd.getTitle());
        /*补全用户信息*/
        if(StpUtil.isLogin()){
            UserVO user = feignSystemService.getUserDetailByUserId(StpUtil.getLoginId(""));
            if (user != null){
                cmd.setOperName(user.getUsername());
                cmd.setDepartmentTitle(user.getDepartmentTitle());
                cmd.setTenantTitle(user.getTenantTitle());
            }
        }
        /*保存*/
        baseFeignLogService.save(cmd);
    }

}
