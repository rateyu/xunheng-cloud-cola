package com.xunheng.system.app;

import com.xunheng.system.client.api.OrganizationService;
import com.xunheng.system.client.dto.OrganizationCreateCmd;
import com.xunheng.system.client.dto.OrganizationUpdateCmd;
import com.xunheng.system.client.dto.VO.OrganizationVO;
import com.xunheng.system.client.dto.query.OrganizationListQuery;
import com.xunheng.system.app.executor.OrganizationCreateCmdExe;
import com.xunheng.system.app.executor.OrganizationRemoveCmdExe;
import com.xunheng.system.app.executor.OrganizationUpdateCmdExe;
import com.xunheng.system.app.executor.query.OrganizationListQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 组织架构service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class OrganizationServiceImpl implements OrganizationService {

    @Resource
    private OrganizationListQueryExe organizationListQueryExe;

    @Resource
    private OrganizationCreateCmdExe organizationCreateCmdExe;

    @Resource
    private OrganizationUpdateCmdExe organizationUpdateCmdExe;

    @Resource
    private OrganizationRemoveCmdExe organizationRemoveCmdExe;

    @Override
    public List<OrganizationVO> getGroupOrganizationList(OrganizationListQuery query) {
        return organizationListQueryExe.execute(query);
    }

    @Override
    public OrganizationVO create(OrganizationCreateCmd cmd) {
        return organizationCreateCmdExe.execute(cmd);
    }

    @Override
    public OrganizationVO update(OrganizationUpdateCmd cmd) {
        return organizationUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
         organizationRemoveCmdExe.execute(id);
    }
}