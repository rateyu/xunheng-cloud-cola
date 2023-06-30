package com.xunheng.system.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.system.app.assembler.RoleAssembler;
import com.xunheng.system.client.dto.query.RolePageQuery;
import com.xunheng.system.domain.role.ability.RoleDomainService;
import com.xunheng.system.domain.role.model.RoleEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色分页查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:55
 */
@Component
public class RolePageQueryExe {

    @Resource
    private RoleDomainService roleDomainService;

    public IPage<RoleVO> execute(RolePageQuery query) {
        IPage<RoleEntity> page = roleDomainService.pageList(query);
        return page.convert(RoleAssembler::toVo);
    }
}
