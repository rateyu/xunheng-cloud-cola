package com.xunheng.system.app.executor.query;

import com.xunheng.base.vo.system.UserLoginVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户登录校验信息查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:02
 */
@Component
public class UserLoginInfoQueryExe {

    @Resource
    private UserGateway userGateway;

    public UserLoginVO execute(String username){
        UserEntity entity = userGateway.getOneByUsername(username);
        return UserAssembler.toUserLoginVO(entity);
    }

}
