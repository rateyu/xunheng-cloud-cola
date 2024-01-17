package com.xunheng.file.app.executor;

import com.xunheng.file.domain.file.gateway.FileGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件删除操作处理器
 * @author: hhqkkr
 * @date: 2023/7/10 12:53
 */
@Component
public class FileRemoveCmdExe {

    @Resource
    FileGateway fileGateway;

    public void execute(String id){
        fileGateway.remove(id);
    }
}
