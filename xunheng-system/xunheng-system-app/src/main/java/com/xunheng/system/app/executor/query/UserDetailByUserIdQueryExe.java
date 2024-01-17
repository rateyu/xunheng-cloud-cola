package com.xunheng.system.app.executor.query;

import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户详情查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:02
 */
@Component
public class UserDetailByUserIdQueryExe {

    @Resource
    private UserDomainService userDomainService;

    public UserVO execute(String userId){
        UserEntity userEntity = userDomainService.getUserDetailById(userId);
        return UserAssembler.toVo(userEntity);
    }

}
