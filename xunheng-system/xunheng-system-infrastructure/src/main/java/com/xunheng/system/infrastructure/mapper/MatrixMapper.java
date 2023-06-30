package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunheng.system.infrastructure.DO.Matrix;
import com.xunheng.system.client.dto.query.MatrixListQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * 矩阵数据处理层
 * @author hhqkkr
 * @date 2022-07-28 16:06:00
 */
@Repository
public interface MatrixMapper extends BaseMapper<Matrix> {

    /**
     * 获取所有矩阵信息列表
     * @param query 查询条件
     * @return 矩阵列表
     */
    List<Matrix> allList(@Param("qry") MatrixListQuery query);
}