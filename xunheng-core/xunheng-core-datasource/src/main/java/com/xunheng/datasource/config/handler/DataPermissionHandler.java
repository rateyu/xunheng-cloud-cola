package com.xunheng.datasource.config.handler;

import cn.dev33.satoken.stp.StpUtil;
import com.google.common.collect.Lists;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.utils.DpContext;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.base.vo.system.UserVO;
import com.xunheng.datasource.client.api.FeignSystemService;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.expression.LongValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @program: xunheng-cloud-cola
 * @description: mybatis数据权限处理器 给拦截器提供需要的数据
 * @author: hhqkkr
 * @date: 2023/6/29 17:02
 */
@Component
public class DataPermissionHandler implements DataPermissionHandlerInterface {

    @Autowired
    private FeignSystemService feignSystemService;

    /**
     * 忽略添加租户ID的表
     */
    private final static List<String> IGNORE_TABLE_NAMES = Lists.newArrayList(
            "qrtz_quartz_job_log",
            "undo_log",
            "erp_export_config"
    );

    /**
     * 获取数据权限基础表达式 在所有语句都会添加
     * 未登录为none
     * 超级管理员为all
     * 普通用户则为对应的租户id
     */
    @Override
    public Expression getPermissionExpression() {
        if(!StpUtil.isLogin())return new LongValue(CommonConstant.DATA_LEVEL_NONE);
        else{
            UserVO user = getCurrUser();
            boolean isSA = Objects.equals(user.getType(), CommonConstant.USER_TYPE_SUPER_ADMIN);
            if(isSA)return new LongValue(CommonConstant.DATA_LEVEL_ALL);
            else return new LongValue(user.getTenantId());
        }
    }

    /**
     * 当前用户详情
     */
    private UserVO getCurrUser(){
        return feignSystemService.getUserDetailByUserId(StpUtil.getLoginId(""));
    }

    /**
     * 当前用户id
     */
    @Override
    public String getUserId() {
        return getCurrUser().getId();
    }

    /**
     * 当前用户与用户下级id
     */
    @Override
    public String getUserLowId() {
        return getCurrUser().getUserLowIds();
    }

    /**
     * 用户租户id
     */
    @Override
    public String getTenantId() {
        return getCurrUser().getTenantId();
    }

    /**
     * 用户分公司id
     */
    @Override
    public String getSubCompanyId() {
        return getCurrUser().getSubCompanyId();
    }

    /**
     * 用户部门id
     */
    @Override
    public String getDepartmentId() {
        return getCurrUser().getOrganizationId();
    }

    /**
     * 用户部门与下级id
     */
    @Override
    public String getDepartmentLowId() {
        return getCurrUser().getDepartmentLowIds();
    }

    /**
     * 是否是忽略权限过滤的表格
     */
    @Override
    public boolean ignoreTable(String tableName) {
        //系统表一律过滤
        if(tableName.contains("sys_"))return true;
        return IGNORE_TABLE_NAMES.contains(tableName);
    }

    /**
     * 用户角色列表
     */
    @Override
    public List<RoleVO> getRoleList(){
        return DpContext.getData() == null ? new ArrayList<>():DpContext.getData();
    }

    /**
     * 当前用户是需要权限过滤
     */
    @Override
    public boolean needPermission(String tableName) {
        List<RoleVO> roleList = getRoleList();
        Boolean isDataAll = false;
        for (RoleVO roleVo : roleList) {
            if(roleVo.getDataLevel() == CommonConstant.DATA_LEVEL_ALL && roleVo.getDataType() == CommonConstant.DATA_TYPE_LEVEL){
                isDataAll = true;
                break;
            }
        }
        if(ignoreTable(tableName) || isDataAll)return false;
        return true;
    }

}
