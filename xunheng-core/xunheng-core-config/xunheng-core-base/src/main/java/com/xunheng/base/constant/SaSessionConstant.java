package com.xunheng.base.constant;

/**
 * @program: xunheng-cloud-cola
 * @description: sa常量
 * @author: hhqkkr
 * @create: 2022-01-01 18:59
 */
public interface SaSessionConstant {

    /**
     * 登录设备类型：PC
     */
    String LOGIN_DEVICE_PC = "PC";

    /**
     * 登录设备类型：APP
     */
    String LOGIN_DEVICE_APP = "APP";

    /**
     * 登录设备类型：WXMP
     */
    String LOGIN_DEVICE_WXMP = "WXMP";

    /**
     * key userinfo
     */
    String USER_INFO_KEY = "user-session::userInfo";


    /**
     * key userPermissionList
     */
    String USER_PERMISSION_LIST_KEY = "permission-session::userPermissionList";

    /**
     * key permissionCodeList
     */
    String PERMISSION_ACTION_CODE_KEY = "permission-session::permissionActionCode";

}
