
package com.xunheng.system.app.executor;

import com.xunheng.system.app.assembler.OrganizationAssembler;
import com.xunheng.system.client.dto.OrganizationCreateCmd;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.domain.organization.ability.OrganizationDomainService;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构新增操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:16
 */
@Component
public class OrganizationCreateCmdExe {

    @Resource
    OrganizationDomainService organizationDomainService;

    public OrganizationVO execute(OrganizationCreateCmd cmd) {
        OrganizationEntity createEntity = OrganizationAssembler.toCreateEntity(cmd);
        return OrganizationAssembler.toVo(organizationDomainService.create(createEntity));
    }

}
