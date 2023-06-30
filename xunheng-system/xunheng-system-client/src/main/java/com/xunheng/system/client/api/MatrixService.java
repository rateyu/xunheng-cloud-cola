package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.MatrixSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.client.dto.query.MatrixListQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:11
 */
public interface MatrixService {

    /**
     * 获取所有矩阵
     * @param query 查询dto
     * @return 矩阵信息列表
     */
    List<MatrixVO> getAll(MatrixListQuery query);

    /**
     * 保存或更新矩阵信息
     * @param cmd 保存操作dto
     * @return 矩阵信息
     */
    MatrixVO saveOrUpdate(MatrixSaveCmd cmd);

    /**
     * 删除矩阵信息
     * @param id 矩阵id
     */
    void remove(String id);
}
