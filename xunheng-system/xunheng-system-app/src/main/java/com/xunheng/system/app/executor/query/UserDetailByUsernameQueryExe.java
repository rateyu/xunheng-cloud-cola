package com.xunheng.system.app.executor.query;

import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 根据用户名查询与童话剧信息处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:02
 */
@Component
public class UserDetailByUsernameQueryExe {

    @Resource
    private UserDomainService userDomainService;

    public UserVO execute(String username){
        UserEntity user = userDomainService.getUserDetailByUsername(username);
        return UserAssembler.toVo(user);
    }

}
