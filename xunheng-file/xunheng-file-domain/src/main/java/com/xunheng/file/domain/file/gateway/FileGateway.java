package com.xunheng.file.domain.file.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.file.client.dto.query.FilePageQuery;
import com.xunheng.file.domain.file.model.FileEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件网关
 * @author: hhqkkr
 * @date: 2023/7/10 15:57
 */
public interface FileGateway {

    /**
     * 文件分页列表
     * @param query 查询条件
     * @return 文件分页信息
     */
    IPage<FileEntity> pageList(FilePageQuery query);

    /**
     * 文件删除
     * @param id 文件id
     */
    void remove(String id);

    /**
     * 文件信息创建
     * @param entity 文件信息
     * @return 文件信息
     */
    FileEntity create(FileEntity entity);

    /**
     * 根据id获取文件信息
     * @param id 文件id
     * @return 文件信息
     */
    FileEntity getOne(String id);
}
