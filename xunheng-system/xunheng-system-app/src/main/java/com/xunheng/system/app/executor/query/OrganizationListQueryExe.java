package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.OrganizationAssembler;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.client.dto.query.OrganizationListQuery;
import com.xunheng.system.domain.organization.gateway.OrganizationGateway;
import com.xunheng.system.domain.organization.model.OrganizationEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:50
 */
@Component
public class OrganizationListQueryExe {
    @Resource
    OrganizationGateway organizationGateway;

    public List<OrganizationVO> execute(OrganizationListQuery query) {
        List<OrganizationEntity> organizationEntityList = organizationGateway.getList(query);
        List<OrganizationVO> voList = organizationEntityList.stream().map(OrganizationAssembler::toVo).collect(Collectors.toList());
        return OrganizationAssembler.toTree(voList);//转换为树结构
    }


}
