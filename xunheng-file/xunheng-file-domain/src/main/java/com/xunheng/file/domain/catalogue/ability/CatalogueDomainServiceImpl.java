package com.xunheng.file.domain.catalogue.ability;

import com.xunheng.file.domain.catalogue.gateway.CatalogueGateway;
import com.xunheng.file.domain.catalogue.model.CatalogueEntity;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 目录领域服务实现类
 * @author: hhqkkr
 * @date: 2023/7/10 13:40
 */
@Component
public class CatalogueDomainServiceImpl implements CatalogueDomainService {

    @Resource
    CatalogueGateway catalogueGateway;

    @Override
    public String getFullDirByCatalogueId(String catalogueId) {
        return getFullDir("",catalogueId);
    }

    /**
     * 递归组装路径
     * @param fdir 初识路径
     * @param catalogueId 目录id
     * @return 完整路径
     */
    String getFullDir(String fdir,String catalogueId){
        CatalogueEntity catalogueEntity = catalogueGateway.getOne(catalogueId);
        String dir = catalogueEntity.getDir();
        fdir += "/"+dir;
        if(StringUtils.isEmpty(catalogueEntity.getParentId()))return fdir;
        else return getFullDir(fdir,catalogueEntity.getParentId());
    }
}
