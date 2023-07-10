package com.xunheng.file.domain.catalogue.gateway;


import com.xunheng.file.domain.catalogue.model.CatalogueEntity;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传目录网关
 * @author: hhqkkr
 * @date: 2023/7/10 12:45
 */
public interface CatalogueGateway {

    /**
     * 插入或更新上传目录
     * @param entity 上传目录信息
     * @return 上传目录信息
     */
    CatalogueEntity saveOrUpdate(CatalogueEntity entity);

    /**
     * 删除上传目录
     * @param id 上传目录id
     */
    void remove(String id);

    /**
     * 查询所有上传目录信息
     * @return 上传目录列表
     */
    List<CatalogueEntity> allList();

    /**
     * 根据id获取目录
     * @param id 目录id
     * @return 目录信息
     */
    CatalogueEntity getOne(String id);

}
