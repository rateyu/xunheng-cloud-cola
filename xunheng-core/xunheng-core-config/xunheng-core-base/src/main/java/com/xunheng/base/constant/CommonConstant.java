package com.xunheng.base.constant;


/**
 * 公共基础常量
 * @author hhqkkr
 */
public interface CommonConstant {

    /****************状态标识**********************/
    /**
     * 正常状态
     */
    Integer STATUS_NORMAL = 0;

    /**
     * 禁用状态
     */
    Integer STATUS_DISABLE = -1;

    /****************用户状态**********************/
    /**
     * 用户正常状态
     */
    Integer USER_STATUS_NORMAL = 0;

    /**
     * 用户禁用状态
     */
    Integer USER_STATUS_LOCK = -1;

    /****************用户类型**********************/
    /**
     * 普通用户
     */
    Integer USER_TYPE_NORMAL = 0;

    /**
     * 分公司管理员
     */
    Integer USER_TYPE_SUB_ADMIN = 1;

    /**
     * 租户管理员
     */
    Integer USER_TYPE_TENANT_ADMIN = 2;

    /**
     * 超级管理员
     */
    Integer USER_TYPE_SUPER_ADMIN = 3;

    /****************数据权限类型**********************/
    /**
     * 数据权限类型 根据数据级别
     */
    Integer DATA_TYPE_LEVEL = 1;

    /**
     * 数据权限类型 根据组织架构范围
     */
    Integer DATA_TYPE_SCOPE = 2;

    /**
     * 数据权限类型 自定义表达式
     */
    Integer DATA_TYPE_CUSTOM = 3;

    /****************数据级别**********************/
    /**
     * 数据级别 无权限
     */
    Integer DATA_LEVEL_NONE = -2;

    /**
     * 数据级别 全平台
     */
    Integer DATA_LEVEL_ALL = -1;

    /**
     * 数据级别 当前租户
     */
    Integer DATA_LEVEL_TENANT = 0;

    /**
     * 数据级别 当前分公司
     */
    Integer DATA_LEVEL_SUB = 1;

    /**
     * 数据级别 当前部门
     */
    Integer DATA_LEVEL_DEPARTMENT = 2;

    /**
     * 数据级别 个人
     */
    Integer DATA_LEVEL_SINGLE = 3;

    /****************权限类型**********************/
    /**
     * 权限类型-菜单
     */
    String PERMISSION_PAGE = "menu";

    /**
     * 权限类型-iframe
     */
    String PERMISSION_IFRAME = "iframe";

    /**
     * 权限类型-外部链接
     */
    String PERMISSION_LINK = "link";

    /**
     * 权限类型-功能组
     */
    String PERMISSION_ACTION_GROUP = "actionGroup";

    /****************组织类型**********************/
    /**
     * 组织类型-总平台
     */
    String ORGANIZATION_HQ = "hq";

    /**
     * 组织类型-租户
     */
    String ORGANIZATION_TENANT = "tenant";

    /**
     * 组织类型-分公司
     */
    String ORGANIZATION_SUB_COMPANY = "sub";

    /**
     * 组织类型-部门
     */
    String ORGANIZATION_DEPARTMENT = "department";

    /****************文件存储方式**********************/
    /**
     * 文件存储方式-本地
     */
    String FILE_UPLOAD_LOCATION_LOCAL = "local";

    /**
     * 文件存储方式-minio
     */
    String FILE_UPLOAD_LOCATION_MINIO = "minio";
}
