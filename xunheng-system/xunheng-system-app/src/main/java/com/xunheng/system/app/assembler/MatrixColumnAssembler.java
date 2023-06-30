package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.VO.MatrixColumnVO;
import com.xunheng.system.domain.matrix.model.MatrixColumnEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵列dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:30
 */
public class MatrixColumnAssembler {

    public static MatrixColumnEntity toSaveEntity(MatrixColumnVO vo) {
        MatrixColumnEntity entity = new MatrixColumnEntity();
        entity.setId(vo.getId());
        entity.setMatrixId(vo.getMatrixId());
        entity.setTitle(vo.getTitle());
        entity.setTag(vo.getTag());
        entity.setType(vo.getType());
        entity.setSortOrder(vo.getSortOrder());
        return entity;
    }

    public static MatrixColumnVO toVo(MatrixColumnEntity entity) {
        if(entity == null)return null;
        MatrixColumnVO vo = new MatrixColumnVO();
        vo.setId(entity.getId());
        vo.setMatrixId(entity.getMatrixId());
        vo.setTitle(entity.getTitle());
        vo.setTag(entity.getTag());
        vo.setType(entity.getType());
        vo.setSortOrder(entity.getSortOrder());
        return vo;
    }

}
