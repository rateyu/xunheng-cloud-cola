
package com.xunheng.system.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户下线操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:28
 */
@Component
public class SaSessionKickOutCmdExe {

    public void execute(String token) {
        StpUtil.logoutByTokenValue(token);
    }

}
