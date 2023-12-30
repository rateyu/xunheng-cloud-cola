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
     * 登录设备类型：微信公众号
     */
    String LOGIN_DEVICE_WOA = "WOA";

    /**
     * 登录设备类型：微信小程序
     */
    String LOGIN_DEVICE_WMA = "WMA";

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
