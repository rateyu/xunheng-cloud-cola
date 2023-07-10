package com.xunheng.file.app.executor;

import com.xunheng.file.domain.catalogue.gateway.CatalogueGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传目录删除操作处理器
 * @author: hhqkkr
 * @date: 2023/7/10 12:53
 */
@Component
public class CatalogueRemoveCmdExe {

    @Resource
    CatalogueGateway catalogueGateway;

    public void execute(String id){
        catalogueGateway.remove(id);
    }
}
