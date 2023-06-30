package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.MatrixSaveCmd;
import com.xunheng.system.client.dto.VO.MatrixVO;
import com.xunheng.system.domain.matrix.model.MatrixEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵信息dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:29
 */
public class MatrixAssembler {
    public static MatrixEntity toSaveEntity(MatrixSaveCmd cmd) {
        MatrixEntity entity = new MatrixEntity();
        entity.setId(cmd.getId());
        entity.setName(cmd.getName());
        entity.setDescription(cmd.getDescription());
        return entity;
    }

    public static MatrixVO toVo(MatrixEntity entity) {
        if(entity == null)return null;
        MatrixVO vo = new MatrixVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setDescription(entity.getDescription());
        return vo;
    }
}
