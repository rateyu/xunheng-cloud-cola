package com.xunheng.file.client.api;

import com.xunheng.file.client.dto.CatalogueSaveCmd;
import com.xunheng.file.client.dto.VO.CatalogueVO;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件目录service
 * @author: hhqkkr
 * @date: 2023/7/10 12:15
 */
public interface CatalogueService {

    /**
     * 获取全部目录信息
     * @return 目录列表
     */
    List<CatalogueVO> allList();

    /**
     * 插入或更新目录信息
     * @param cmd 目录保存操作dto
     * @return 目录信息
     */
    CatalogueVO saveOrUpdate(CatalogueSaveCmd cmd);

    /**
     * 目录删除
     * @param id 目录id
     */
    void remove(String id);

}
