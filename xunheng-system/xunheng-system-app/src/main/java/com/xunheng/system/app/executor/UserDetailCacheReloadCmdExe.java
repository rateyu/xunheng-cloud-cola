
package com.xunheng.system.app.executor;

import cn.dev33.satoken.session.SaSession;
import cn.dev33.satoken.stp.StpUtil;
import com.alibaba.fastjson.JSON;
import com.xunheng.base.constant.SaSessionConstant;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.executor.query.UserDetailByUserIdQueryExe;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户信息缓存刷新处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:31
 */
@Component
public class UserDetailCacheReloadCmdExe {

    @Resource
    private UserDomainService userDomainService;

    public void execute(String userId) {
        userDomainService.reloadUserDetailCache(userId);
    }

}
