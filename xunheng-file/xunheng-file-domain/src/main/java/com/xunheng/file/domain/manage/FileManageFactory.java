package com.xunheng.file.domain.manage;

import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.file.domain.manage.impl.LocalFileManage;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * 文件上传管理工厂模式
 */
@Component
public class FileManageFactory {

    @Resource
    private LocalFileManage localFileManage;

    /**
     * 根据配置获取上传的方案
     * @param location 上传地址方式
     * @return 对应的上传处理
     */
    public FileManage getFileManage(String location) {
         if (location.equals(CommonConstant.FILE_UPLOAD_LOCATION_LOCAL)) {
            return localFileManage;
        } else {
            throw new GlobalException("无当前文件存储配置");
        }
    }

}
