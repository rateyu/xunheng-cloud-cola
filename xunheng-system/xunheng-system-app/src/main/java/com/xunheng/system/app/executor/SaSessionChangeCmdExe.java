
package com.xunheng.system.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import org.springframework.stereotype.Component;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @program: xunheng-cloud-cola
 * @description: 身份切换操作处理器 beta
 * @author: hhqkkr
 * @date: 2023/6/29 23:28
 */
@Component
public class SaSessionChangeCmdExe {

    public void execute(String token) {
        String loginId = StpUtil.getLoginIdByToken(token)+"";
        System.out.println("------- [身份临时切换]调用开始...");
        StpUtil.switchTo(loginId);
        //设定一个定时器 5分钟后自定切换回来
        TimerTask task = new TimerTask() {
            @Override
            public void run() {
                StpUtil.endSwitch();
                System.out.println("------- [身份临时切换]调用结束...");
            }
        };
        Timer timer = new Timer();
        // 定义开始等待时间  --- 等待 15分钟
        long delay = 60000;
        timer.schedule(task,delay);
    }

}
