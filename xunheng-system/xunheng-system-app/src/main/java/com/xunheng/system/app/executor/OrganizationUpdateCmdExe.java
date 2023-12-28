
package com.xunheng.system.app.executor;

import com.xunheng.system.app.assembler.OrganizationAssembler;
import com.xunheng.system.client.dto.OrganizationUpdateCmd;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.domain.organization.ability.OrganizationDomainService;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构更新操作处理器
 * @author: hhqkkr
 * @date: 2023/6/29 23:17
 */
@Component
public class OrganizationUpdateCmdExe {

    @Resource
    OrganizationDomainService organizationDomainService;

    public OrganizationVO execute(OrganizationUpdateCmd cmd) {
        OrganizationEntity updateEntity = OrganizationAssembler.toUpdateEntity(cmd);
        return OrganizationAssembler.toVo(organizationDomainService.update(updateEntity));
    }

}
