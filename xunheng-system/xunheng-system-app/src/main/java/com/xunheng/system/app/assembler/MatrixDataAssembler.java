package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.VO.MatrixDataVO;
import com.xunheng.system.domain.matrix.model.MatrixDataEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:30
 */
public class MatrixDataAssembler {

    public static MatrixDataEntity toSaveEntity(MatrixDataVO vo) {
        MatrixDataEntity entity = new MatrixDataEntity();
        entity.setId(vo.getId());
        entity.setMatrixId(vo.getMatrixId());
        entity.setColumnTag(vo.getColumnTag());
        entity.setRowId(vo.getRowId());
        entity.setData(vo.getData());
        return entity;
    }

    public static MatrixDataVO toVo(MatrixDataEntity entity) {
        if(entity == null)return null;
        MatrixDataVO vo = new MatrixDataVO();
        vo.setId(entity.getId());
        vo.setMatrixId(entity.getMatrixId());
        vo.setColumnTag(entity.getColumnTag());
        vo.setRowId(entity.getRowId());
        vo.setData(entity.getData());
        return vo;
    }

}
