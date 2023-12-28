package com.xunheng.system.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.system.app.assembler.UserAssembler;
import com.xunheng.system.client.dto.query.UserPageQuery;
import com.xunheng.system.domain.user.gateway.UserGateway;
import com.xunheng.system.domain.user.gateway.UserRoleGateway;
import com.xunheng.system.domain.user.model.UserEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 用户信息分页查询处理器去
 * @author: hhqkkr
 * @date: 2023/6/29 23:03
 */
@Component
public class UserPageQueryExe {

    @Resource
    private UserGateway userGateway;

    @Resource
    private UserRoleGateway userRoleGateway;

    public IPage<UserVO> execute(UserPageQuery query) {
        IPage<UserEntity> page = userGateway.pageList(query);
        page.convert(u ->{//绑定角色信息
            u.bindRoleInfo(userRoleGateway.getByUserId(u.getId()));
            return u;
        });
        return page.convert(UserAssembler::toVo);
    }
}
