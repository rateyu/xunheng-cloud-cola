package com.xunheng.file.app.executor;

import com.xunheng.file.app.assembler.CatalogueAssembler;
import com.xunheng.file.client.dto.CatalogueSaveCmd;
import com.xunheng.file.client.dto.VO.CatalogueVO;
import com.xunheng.file.domain.catalogue.gateway.CatalogueGateway;
import com.xunheng.file.domain.catalogue.model.CatalogueEntity;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 目录保存操作处理器
 * @author: hhqkkr
 * @date: 2023/7/10 12:44
 */
@Component
public class CatalogueSaveCmdExe {

    @Resource
    CatalogueGateway catalogueGateway;

    public CatalogueVO execute(CatalogueSaveCmd cmd){
        CatalogueEntity entity = catalogueGateway.saveOrUpdate(CatalogueAssembler.toEntity(cmd));
        return CatalogueAssembler.toVo(entity);
    }
}
