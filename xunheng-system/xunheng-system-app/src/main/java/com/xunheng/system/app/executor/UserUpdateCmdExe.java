
package com.xunheng.system.app.executor;

import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.client.dto.UserUpdateCmd;
import com.xunheng.system.domain.user.ability.UserDomainService;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户更新操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:31
 */
@Component
public class UserUpdateCmdExe {

    @Resource
    private UserGateway userGateway;

    @Resource
    private UserDomainService userDomainService;

    public UserVO execute(UserUpdateCmd cmd) {
        UserEntity updateEntity = UserAssembler.toUpdateEntity(cmd);
        updateEntity = userGateway.saveOrUpdate(updateEntity);
        userDomainService.reloadUserDetailCache(cmd.getId());//刷新用户信息缓存
        return UserAssembler.toVo(updateEntity);
    }

}
