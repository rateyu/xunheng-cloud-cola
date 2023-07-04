package com.xunheng.generator.app.assembler;

import com.xunheng.generator.client.dto.VO.GenConfigFieldVO;
import com.xunheng.generator.domain.genConfig.model.GenFieldConfigEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成字段配置dto转换
 * @author: hhqkkr
 * @date: 2023/7/3 17:13
 */
public class GenFieldConfigAssembler {

    public static GenFieldConfigEntity toEntity(GenConfigFieldVO vo){
        if(vo == null)return null;
        GenFieldConfigEntity entity = new GenFieldConfigEntity();
        entity.setFieldName(vo.getFieldName());
        entity.setDescription(vo.getDescription());
        entity.setType(vo.getType());
        entity.setDefaultVal(vo.getDefaultVal());
        entity.setCindex(vo.getCindex());
        entity.setNotNull(vo.getNotNull());
        entity.setFieldUpperCaseName(entity.name(entity.getFieldName(),true));
        return entity;
    }

    public static GenConfigFieldVO toVO(GenFieldConfigEntity entity){
        if(entity == null)return null;
        GenConfigFieldVO vo = new GenConfigFieldVO();
        vo.setId(entity.getId());
        vo.setFieldName(entity.getFieldName());
        vo.setDescription(entity.getDescription());
        vo.setType(entity.getType());
        vo.setDefaultVal(entity.getDefaultVal());
        vo.setCindex(entity.getCindex());
        vo.setNotNull(entity.getNotNull());
        return vo;
    }
}
