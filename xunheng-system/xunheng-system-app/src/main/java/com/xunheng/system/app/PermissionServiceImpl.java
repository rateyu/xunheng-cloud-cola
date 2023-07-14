package com.xunheng.system.app;

import com.xunheng.base.vo.system.PermissionVO;
import com.xunheng.system.app.executor.PermissionCreateCmdExe;
import com.xunheng.system.app.executor.PermissionRemoveCmdExe;
import com.xunheng.system.app.executor.PermissionUpdateCmdExe;
import com.xunheng.system.client.api.PermissionService;
import com.xunheng.system.client.dto.PermissionCreateCmd;
import com.xunheng.system.client.dto.PermissionUpdateCmd;
import com.xunheng.system.client.dto.VO.UserPermissionVO;
import com.xunheng.system.app.executor.query.SystemPermissionListQueryExe;
import com.xunheng.system.app.executor.query.UserPermissionQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 权限service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class PermissionServiceImpl implements PermissionService {

    @Resource
    private PermissionCreateCmdExe permissionCreateCmdExe;

    @Resource
    private PermissionUpdateCmdExe permissionUpdateCmdExe;

    @Resource
    private PermissionRemoveCmdExe permissionRemoveCmdExe;

    @Resource
    private UserPermissionQueryExe userPermissionQueryExe;

    @Resource
    private SystemPermissionListQueryExe systemPermissionListQueryExe;

    @Override
    public UserPermissionVO getUserPermission() {
        return userPermissionQueryExe.execute();
    }

    @Override
    public List<PermissionVO> getSystemPermissionList() {
        return systemPermissionListQueryExe.execute();
    }

    @Override
    public PermissionVO create(PermissionCreateCmd cmd) {
        return permissionCreateCmdExe.execute(cmd);
    }

    @Override
    public PermissionVO update(PermissionUpdateCmd cmd) {
        return permissionUpdateCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        permissionRemoveCmdExe.execute(id);
    }
}