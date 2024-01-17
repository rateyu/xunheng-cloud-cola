package com.xunheng.system.app.executor;

import cn.dev33.satoken.stp.StpUtil;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.domain.user.ability.UserDomainService;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 根据token获取用户信息
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Component
public class UserInfoByTokenQueryExe {

    @Resource
    private UserDomainService userDomainService;

    public UserVO execute(String token){
        String userId = String.valueOf(StpUtil.getLoginIdByToken(token));
        return UserAssembler.toVo(userDomainService.getUserDetailById(userId));
    }

}
