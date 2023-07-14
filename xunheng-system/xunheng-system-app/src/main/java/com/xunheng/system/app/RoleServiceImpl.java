package com.xunheng.system.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.vo.SelectItemVO;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.system.app.executor.query.*;
import com.xunheng.system.client.api.RoleService;
import com.xunheng.system.client.dto.RolePermEditCmd;
import com.xunheng.system.client.dto.RoleSaveCmd;
import com.xunheng.system.client.dto.query.RolePageQuery;
import com.xunheng.system.app.executor.RoleEditPermCmdExe;
import com.xunheng.system.app.executor.RoleRemoveCmdExe;
import com.xunheng.system.app.executor.RoleSaveCmdExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 角色service实现类
 * @author: hhqkkr
 * @date: 2023/6/29 23:37
 */
@Service
@GlobalTransactional
public class RoleServiceImpl implements RoleService {

    @Resource
    private RoleSelectItemQueryExe roleSelectItemQueryExe;

    @Resource
    RolePageQueryExe rolePageQueryExe;

    @Resource
    RoleListQueryExe roleListQueryExe;

    @Resource
    RoleEditPermCmdExe roleEditPermCmdExe;

    @Resource
    RoleSaveCmdExe roleSaveCmdExe;

    @Resource
    RoleRemoveCmdExe roleRemoveCmdExe;

    @Resource
    RoleByUserAndActionQueryExe roleByUserAndActionQueryExe;

    @Override
    public List<SelectItemVO> getSelectItem() {
        return roleSelectItemQueryExe.execute();
    }

    @Override
    public IPage<RoleVO> pageList(RolePageQuery query) {
        return rolePageQueryExe.execute(query);
    }

    @Override
    public List<RoleVO> getAll() {
        return roleListQueryExe.execute();
    }

    @Override
    public void editRolePerm(RolePermEditCmd cmd) {
        roleEditPermCmdExe.execute(cmd);
    }

    @Override
    public RoleVO saveOrUpdate(RoleSaveCmd cmd) {
        return roleSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        roleRemoveCmdExe.execute(id);
    }

    @Override
    public List<RoleVO> getRoleByUserAndAction(String userId, String code) {
        return roleByUserAndActionQueryExe.execute(userId,code);
    }
}