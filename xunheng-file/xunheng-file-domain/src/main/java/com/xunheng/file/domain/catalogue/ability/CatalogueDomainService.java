package com.xunheng.file.domain.catalogue.ability;

/**
 * @program: xunheng-cloud-cola
 * @description: 目录领域服务
 * @author: hhqkkr
 * @date: 2023/7/10 13:39
 */
public interface CatalogueDomainService {

    /**
     * @program: xunheng-cloud-cola
     * @description: 根据目录id拿到文件路径
     * @author: hhqkkr
     * @date: 2023/7/10 13:39
     */
    String getFullDirByCatalogueId(String catalogueId);
}
