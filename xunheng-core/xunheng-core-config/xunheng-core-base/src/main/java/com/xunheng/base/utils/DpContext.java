package com.xunheng.base.utils;


import com.xunheng.base.vo.system.RoleVO;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description:
 * @author: hhqkkr
 * @create: 2022-01-11 12:01
 */
public class DpContext {
    private DpContext() {

    }

    private static ThreadLocal<List<RoleVO>> dpHolder = new ThreadLocal<>();

/*    public static Map<String,Object> getDataMap() {
        return dpHolder.get() == null ? new HashMap<String,Object>():dpHolder.get();
    }

    public static void setData(String key,Object value) {
        Map<String, Object> map = dpHolder.get();
        map.put(key,value);
        dpHolder.set(map);
    }

    public static Integer getDataLevel(){
        Map<String, Object> dataMap = getDataMap();
        Object dataLevel = dataMap.get("dataLevel");
        if(dataLevel == null)return CommonConstant.DATA_LEVEL_NONE;
        else return Integer.parseInt(dataLevel+"");
    }

    public static void SetDataLevel(Integer dataLevel){
        Map<String, Object> dataMap = getDataMap();
        dataMap.put("dataLevel",dataLevel);
    }*/
    public static List<RoleVO> getData() {
        return dpHolder.get();
    }

    public static void setData(List<RoleVO> roleList) {
        dpHolder.set(roleList);
    }

    public static void clean() {
        dpHolder.remove();
    }
}
