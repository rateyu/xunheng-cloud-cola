package com.xunheng.datasource.config.handler;

import com.xunheng.base.vo.system.RoleVO;
import net.sf.jsqlparser.expression.Expression;
import net.sf.jsqlparser.schema.Column;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 数据权限处理器接口
 * @author: hhqkkr
 * @create: 2022-01-11 13:12
 */
public interface DataPermissionHandlerInterface {
    /**
     * 权限过滤表达式
     * @return
     */
    Expression getPermissionExpression();


    String getUserId();

    String getUserLowId();

    String getTenantId();

    String getSubCompanyId();

    String getDepartmentId();

    String getDepartmentLowId();

    /**
     * 是否是忽略的表格
     * @param tableName 表格名称
     * @return
     */
    default boolean ignoreTable(String tableName) {
        return false;
    }

    /**
     * 是否需要权限过滤
     * @param tableName 表格名称
     * @return
     */
    boolean needPermission(String tableName);

    public List<RoleVO> getRoleList();

    default boolean ignoreInsert(List<Column> columns, String tenantIdColumn) {
        return columns.stream().map(Column::getColumnName).anyMatch((i) -> {
            return i.equalsIgnoreCase(tenantIdColumn);
        });
    }
}
