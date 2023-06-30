package com.xunheng.datasource.config.interceptor;

import com.baomidou.mybatisplus.core.plugins.InterceptorIgnoreHelper;
import com.baomidou.mybatisplus.core.toolkit.ClassUtils;
import com.baomidou.mybatisplus.core.toolkit.CollectionUtils;
import com.baomidou.mybatisplus.core.toolkit.PluginUtils;
import com.baomidou.mybatisplus.extension.parser.JsqlParserSupport;
import com.baomidou.mybatisplus.extension.plugins.inner.InnerInterceptor;
import com.baomidou.mybatisplus.extension.toolkit.PropertyMapper;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.vo.system.RoleVO;
import com.xunheng.datasource.config.handler.DataPermissionHandlerInterface;
import lombok.extern.slf4j.Slf4j;
import net.sf.jsqlparser.JSQLParserException;
import net.sf.jsqlparser.expression.*;
import net.sf.jsqlparser.expression.operators.conditional.AndExpression;
import net.sf.jsqlparser.expression.operators.conditional.OrExpression;
import net.sf.jsqlparser.expression.operators.relational.*;
import net.sf.jsqlparser.parser.CCJSqlParserManager;
import net.sf.jsqlparser.parser.CCJSqlParserUtil;
import net.sf.jsqlparser.schema.Column;
import net.sf.jsqlparser.schema.Table;
import net.sf.jsqlparser.statement.delete.Delete;
import net.sf.jsqlparser.statement.select.*;
import net.sf.jsqlparser.statement.update.Update;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.statement.StatementHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.SqlCommandType;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;

import java.io.StringReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.*;

/**
 * @program: xunheng-cloud-cola
 * @description: 数据权限拦截器 解决多租户 数据等级权限等
 * @author: hhqkkr
 * @create: 2022-01-06 16:05
 */
@Slf4j
public class DataPermissionInterceptor extends JsqlParserSupport implements InnerInterceptor {

    private DataPermissionHandlerInterface dpHandler;

    public DataPermissionInterceptor() {
    }

    public DataPermissionInterceptor(final DataPermissionHandlerInterface dataPermissionHandler) {
        this.dpHandler = dataPermissionHandler;
    }

    public DataPermissionHandlerInterface getDataPermissionHandler() {
        return this.dpHandler;
    }

    public void setDataPermissionHandler(final DataPermissionHandlerInterface dataPermissionHandler) {
        this.dpHandler = dataPermissionHandler;
    }


    public void setProperties(Properties properties) {
        PropertyMapper.newInstance(properties).whenNotBlank("dataPermissionHandler", ClassUtils::newInstance, this::setDataPermissionHandler);
    }

    public void beforeQuery(Executor executor, MappedStatement ms, Object parameter, RowBounds rowBounds, ResultHandler resultHandler, BoundSql boundSql) throws SQLException {
        if (!InterceptorIgnoreHelper.willIgnoreTenantLine(ms.getId())) {
            PluginUtils.MPBoundSql mpBs = PluginUtils.mpBoundSql(boundSql);
            mpBs.sql(this.parserSingle(mpBs.sql(), (Object)null));
        }
    }

    public void beforePrepare(StatementHandler sh, Connection connection, Integer transactionTimeout) {
        PluginUtils.MPStatementHandler mpSh = PluginUtils.mpStatementHandler(sh);
        MappedStatement ms = mpSh.mappedStatement();
        SqlCommandType sct = ms.getSqlCommandType();
        if (sct == SqlCommandType.UPDATE || sct == SqlCommandType.DELETE) {
            if (InterceptorIgnoreHelper.willIgnoreTenantLine(ms.getId())) {
                return;
            }

            PluginUtils.MPBoundSql mpBs = mpSh.mPBoundSql();
            mpBs.sql(this.parserMulti(mpBs.sql(), (Object)null));
        }

    }

    protected void processSelect(Select select, int index, String sql, Object obj) {
        this.processSelectBody(select.getSelectBody());
        List<WithItem> withItemsList = select.getWithItemsList();
        if (!CollectionUtils.isEmpty(withItemsList)) {
            withItemsList.forEach(this::processSelectBody);
        }

    }

    protected void processSelectBody(SelectBody selectBody) {
        if (selectBody != null) {
            if (selectBody instanceof PlainSelect) {
                this.processPlainSelect((PlainSelect)selectBody);
            } else if (selectBody instanceof WithItem) {
                WithItem withItem = (WithItem)selectBody;
                this.processSelectBody(withItem.getSubSelect().getSelectBody());
            } else {
                SetOperationList operationList = (SetOperationList)selectBody;
                List<SelectBody> selectBodys = operationList.getSelects();
                if (CollectionUtils.isNotEmpty(selectBodys)) {
                    selectBodys.forEach(this::processSelectBody);
                }
            }

        }
    }

    protected void processUpdate(Update update, int index, String sql, Object obj) {
        Table table = update.getTable();
        if (dpHandler.needPermission(update.getTable().getName())) {
            update.setWhere(this.andExpression(table, update.getWhere(),"update"));
        }
    }

    protected void processDelete(Delete delete, int index, String sql, Object obj) {
        if (dpHandler.needPermission(delete.getTable().getName())) {
            delete.setWhere(this.andExpression(delete.getTable(), delete.getWhere(),"delete"));
        }
    }

    protected Expression andExpression(Table table, Expression where,String from) {
        Expression permissionExpression = handlePermissionExpression(table,from);
        if(permissionExpression == null)permissionExpression = getEqualOne();
        if (null != where) {
            return where instanceof OrExpression ? new AndExpression(new Parenthesis(permissionExpression), new Parenthesis(where)) : new AndExpression(new Parenthesis(permissionExpression), where);
        } else {
            return  permissionExpression;
        }
    }

    private Expression inExpression(String where,Table table) throws JSQLParserException{
        CCJSqlParserManager parserManager = new CCJSqlParserManager();
        String sql = "select 1 from sys_a where "+getTableAlias(table)+where;
        Select select = (Select) parserManager.parse(new StringReader(sql));
        PlainSelect plain = (PlainSelect) select.getSelectBody();
        Expression where_expression = plain.getWhere();
        return  where_expression;
    }

    private EqualsTo getEqualOne(){
        EqualsTo equalOne = new EqualsTo();
        equalOne.setLeftExpression(new Column("1"));
        equalOne.setRightExpression(new LongValue(1));
        return equalOne;
    }

    protected void processPlainSelect(PlainSelect plainSelect) {
        FromItem fromItem = plainSelect.getFromItem();
        Expression where = plainSelect.getWhere();
        this.processWhereSubSelect(where);
        if (fromItem instanceof Table) {
            Table fromTable = (Table)fromItem;
            if (dpHandler.needPermission(fromTable.getName())) {
                plainSelect.setWhere(this.builderExpression(where, fromTable,"plainSelect"));
            }
        } else {
            this.processFromItem(fromItem);
        }

        List<SelectItem> selectItems = plainSelect.getSelectItems();
        if (CollectionUtils.isNotEmpty(selectItems)) {
            selectItems.forEach(this::processSelectItem);
        }

        List<Join> joins = plainSelect.getJoins();
        if (CollectionUtils.isNotEmpty(joins)) {
            this.processJoins(joins);
        }

    }

    protected void processWhereSubSelect(Expression where) {
        if (where != null) {
            if (where instanceof FromItem) {
                this.processFromItem((FromItem)where);
            } else {
                if (where.toString().indexOf("SELECT") > 0) {
                    if (where instanceof BinaryExpression) {
                        BinaryExpression expression = (BinaryExpression)where;
                        this.processWhereSubSelect(expression.getLeftExpression());
                        this.processWhereSubSelect(expression.getRightExpression());
                    } else if (where instanceof InExpression) {
                        InExpression expression = (InExpression)where;
                        ItemsList itemsList = expression.getRightItemsList();
                        if (itemsList instanceof SubSelect) {
                            this.processSelectBody(((SubSelect)itemsList).getSelectBody());
                        }
                    } else if (where instanceof ExistsExpression) {
                        ExistsExpression expression = (ExistsExpression)where;
                        this.processWhereSubSelect(expression.getRightExpression());
                    } else if (where instanceof NotExpression) {
                        NotExpression expression = (NotExpression)where;
                        this.processWhereSubSelect(expression.getExpression());
                    } else if (where instanceof Parenthesis) {
                        Parenthesis expression = (Parenthesis)where;
                        this.processWhereSubSelect(expression.getExpression());
                    }
                }

            }
        }
    }

    protected void processSelectItem(SelectItem selectItem) {
        if (selectItem instanceof SelectExpressionItem) {
            SelectExpressionItem selectExpressionItem = (SelectExpressionItem)selectItem;
            if (selectExpressionItem.getExpression() instanceof SubSelect) {
                this.processSelectBody(((SubSelect)selectExpressionItem.getExpression()).getSelectBody());
            } else if (selectExpressionItem.getExpression() instanceof Function) {
                this.processFunction((Function)selectExpressionItem.getExpression());
            }
        }

    }

    protected void processFunction(Function function) {
        ExpressionList parameters = function.getParameters();
        if (parameters != null) {
            parameters.getExpressions().forEach((expression) -> {
                if (expression instanceof SubSelect) {
                    this.processSelectBody(((SubSelect)expression).getSelectBody());
                } else if (expression instanceof Function) {
                    this.processFunction((Function)expression);
                }
            });
        }

    }

    protected void processFromItem(FromItem fromItem) {
        if (fromItem instanceof SubJoin) {
            SubJoin subJoin = (SubJoin)fromItem;
            if (subJoin.getJoinList() != null) {
                this.processJoins(subJoin.getJoinList());
            }

            if (subJoin.getLeft() != null) {
                this.processFromItem(subJoin.getLeft());
            }
        } else if (fromItem instanceof SubSelect) {
            SubSelect subSelect = (SubSelect)fromItem;
            if (subSelect.getSelectBody() != null) {
                this.processSelectBody(subSelect.getSelectBody());
            }
        } else if (fromItem instanceof ValuesList) {
            this.logger.debug("Perform a subquery, if you do not give us feedback");
        } else if (fromItem instanceof LateralSubSelect) {
            LateralSubSelect lateralSubSelect = (LateralSubSelect)fromItem;
            if (lateralSubSelect.getSubSelect() != null) {
                SubSelect subSelect = lateralSubSelect.getSubSelect();
                if (subSelect.getSelectBody() != null) {
                    this.processSelectBody(subSelect.getSelectBody());
                }
            }
        }

    }

    private void processJoins(List<Join> joins) {
        Deque<Table> tables = new LinkedList();
        Iterator var3 = joins.iterator();
        while(true) {
            while(true) {
                while(var3.hasNext()) {
                    Join join = (Join)var3.next();
                    FromItem fromItem = join.getRightItem();
                    if (fromItem instanceof Table) {
                        Table fromTable = (Table)fromItem;
                        Collection<Expression> originOnExpressions = join.getOnExpressions();
                        if (originOnExpressions.size() == 1) {
                            this.processJoin(join);
                        } else {
                            boolean needPermission = dpHandler.needPermission(fromTable.getName());
                            tables.push(!needPermission ? null : fromTable);
                            if (originOnExpressions.size() > 1) {
                                Collection<Expression> onExpressions = new LinkedList();
                                Iterator var10 = originOnExpressions.iterator();
                                while(var10.hasNext()) {
                                    Expression originOnExpression = (Expression)var10.next();
                                    Table currentTable = (Table)tables.poll();
                                    if (currentTable == null) {
                                        onExpressions.add(originOnExpression);
                                    } else {
                                        onExpressions.add(this.builderExpression(originOnExpression, currentTable,"processJoins"));
                                    }
                                }
                                join.setOnExpressions(onExpressions);
                            }
                        }
                    } else {
                        this.processFromItem(fromItem);
                    }
                }
                return;
            }
        }
    }

    protected void processJoin(Join join) {
        if (join.getRightItem() instanceof Table) {
            Table fromTable = (Table)join.getRightItem();
            if (!dpHandler.needPermission(fromTable.getName())) {
                return;
            }
            Collection<Expression> originOnExpressions = join.getOnExpressions();
            List<Expression> onExpressions = new LinkedList();
            onExpressions.add(this.builderExpression((Expression)originOnExpressions.iterator().next(), fromTable,"processJoin"));
            join.setOnExpressions(onExpressions);
        }

    }

    protected Expression builderExpression(Expression currentExpression, Table table,String from) {
        Expression permissionExpression = handlePermissionExpression(table,from);
        if(permissionExpression == null)permissionExpression = getEqualOne();
        if (currentExpression == null) {
            return permissionExpression;
        } else {
            return currentExpression instanceof OrExpression ? new AndExpression(new Parenthesis(currentExpression), new Parenthesis(permissionExpression)) : new AndExpression(currentExpression, new Parenthesis(permissionExpression));
        }
    }

    protected String getTableAlias(Table table) {
        StringBuilder str = new StringBuilder();
        if (table.getAlias() != null) {
            str.append(table.getAlias().getName()).append(".");
        }
        return str.toString();
    }


    private Expression handlePermissionExpression(Table table,String from)  {
        Expression permissionExpression = null;
        try {
            List<RoleVO> roleList = dpHandler.getRoleList();
            for (RoleVO roleVo : roleList) {
                Integer dataType = roleVo.getDataType();
                Expression currentExpression = null;
                if(dataType.equals(CommonConstant.DATA_TYPE_LEVEL)){
                    currentExpression = handleDataTypeLevel(roleVo,table,from);
                }else if(dataType.equals(CommonConstant.DATA_TYPE_SCOPE)){//未开源

                }else if(dataType.equals(CommonConstant.DATA_TYPE_CUSTOM)){//未开源

                }
                if(permissionExpression == null ){
                    permissionExpression = currentExpression;
                }else{
                    permissionExpression = new OrExpression(new Parenthesis(currentExpression),permissionExpression);
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return permissionExpression;
    }

    private Expression handleDataTypeLevel(RoleVO roleVo, Table table, String from) throws JSQLParserException {
         /*
            ######################################################
                                -> 部门 -> 部门
             组织架构：平台 -> 租户
                                -> 分公司 -> 部门 -> 部门
            #######################################################
             DATA_LEVEL_NONE : where 1 = 0
             DATA_LEVEL_ALL : null
             DATA_LEVEL_TENANT: where table.tenant_id = #{tenantId}
             DATA_LEVEL_SUB: where table.sub_company_id = #{subCompanyId}
             DATA_LEVEL_DEPARTMENT && !includeLow: where table.department_id = #{departmentId}
             DATA_LEVEL_DEPARTMENT && includeLow: where table.department_id in (#{departmentIds})
             DATA_LEVEL_SINGLE && !includeLow: where table.create_by = #{userId}
             DATA_LEVEL_SINGLE && includeLow: where table.create_by in (#{userIds})
         */
        Integer dataLevel = roleVo.getDataLevel();
        Integer includeLow = roleVo.getIncludeLow();
        String tenantWhere  =  "tenant_id in (" + dpHandler.getTenantId()+",-1)";//tenant id 为 -1时 为公用数据
        Expression tenantExpression = inExpression(tenantWhere,table);
        Expression expression = null;
        if(dataLevel.equals(CommonConstant.DATA_LEVEL_TENANT)){
            return  tenantExpression;
        }else if(dataLevel.equals(CommonConstant.DATA_LEVEL_SUB)){
            expression =  CCJSqlParserUtil.parseCondExpression(getTableAlias(table)+"sub_company_id = "+dpHandler.getSubCompanyId());
        }else if(dataLevel.equals(CommonConstant.DATA_LEVEL_DEPARTMENT)&& includeLow == 0){
            expression = CCJSqlParserUtil.parseCondExpression(getTableAlias(table)+"department_id = "+dpHandler.getDepartmentId());
        }else if(dataLevel.equals(CommonConstant.DATA_LEVEL_DEPARTMENT)&& includeLow == 1){
            String departmentLowId = dpHandler.getDepartmentLowId();
            String where = "department_id in ("+departmentLowId+")";
            expression = inExpression(where,table);
        }else if(dataLevel.equals(CommonConstant.DATA_LEVEL_SINGLE) && includeLow == 0){
            expression = CCJSqlParserUtil.parseCondExpression(getTableAlias(table)+"create_by = "+dpHandler.getUserId());
        }else if(dataLevel.equals(CommonConstant.DATA_LEVEL_SINGLE) && includeLow == 1){
            String userLowId = dpHandler.getUserLowId();
            String where = "create_by in ("+userLowId+")";
            expression = inExpression(where,table);
        }else{
            expression = CCJSqlParserUtil.parseCondExpression("1 = 0");
        }
        return new AndExpression(tenantExpression,expression);
    }

}
