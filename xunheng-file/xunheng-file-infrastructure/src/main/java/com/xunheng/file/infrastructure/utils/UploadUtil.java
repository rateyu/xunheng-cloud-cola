package com.xunheng.file.infrastructure.utils;


import com.xunheng.base.utils.SnowFlakeUtil;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传工具类
 * @author: hhqkkr
 * @date: 2023/7/10 16:30
 */
public class UploadUtil {

    /**
     * 文件重命名
     * @param oriName 文件原名
     * @return 重命名后的文件名
     */
    public static String renameFile(String oriName){
        String extName = "";
        if (oriName.contains(".")) {
            extName = oriName.substring(oriName.lastIndexOf("."));
        }
        return SnowFlakeUtil.nextId().toString() + extName;
    }
}
