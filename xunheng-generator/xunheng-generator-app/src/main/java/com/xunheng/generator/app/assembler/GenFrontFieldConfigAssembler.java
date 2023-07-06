package com.xunheng.generator.app.assembler;

import com.xunheng.generator.client.dto.VO.GenConfigFieldVO;
import com.xunheng.generator.client.dto.VO.GenFrontConfigFieldVO;
import com.xunheng.generator.domain.genConfig.model.GenFieldConfigEntity;
import com.xunheng.generator.domain.genConfig.model.GenFrontFieldConfigEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 前端代码生成字段配置dto转换
 * @author: hhqkkr
 * @date: 2023/7/3 17:13
 */
public class GenFrontFieldConfigAssembler {

    public static GenFrontFieldConfigEntity toEntity(GenFrontConfigFieldVO vo){
        if(vo == null)return null;
        GenFrontFieldConfigEntity entity = new GenFrontFieldConfigEntity();
        entity.setFieldName(vo.getFieldName());
        entity.setDescription(vo.getDescription());
        entity.setType(vo.getType());
        entity.setColWidth(vo.getColWidth());
        entity.setDictType(vo.getDictType());
        entity.setApi(vo.getApi());
        entity.setSearchable(vo.getSearchable());
        entity.setSearchType(vo.getSearchType());
        return entity;
    }

    public static GenFrontConfigFieldVO toVO(GenFrontFieldConfigEntity entity){
        if(entity == null)return null;
        GenFrontConfigFieldVO vo = new GenFrontConfigFieldVO();
        vo.setId(entity.getId());
        vo.setFieldName(entity.getFieldName());
        vo.setDescription(entity.getDescription());
        vo.setType(entity.getType());
        vo.setColWidth(entity.getColWidth());
        vo.setDictType(entity.getDictType());
        vo.setApi(entity.getApi());
        vo.setSearchable(entity.getSearchable());
        vo.setSearchType(entity.getSearchType());
        return vo;
    }
}
