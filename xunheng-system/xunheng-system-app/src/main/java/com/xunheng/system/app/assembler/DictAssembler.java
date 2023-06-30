package com.xunheng.system.app.assembler;

import com.xunheng.system.client.dto.DictSaveCmd;
import com.xunheng.system.client.dto.VO.DictVO;
import com.xunheng.system.domain.dict.model.DictEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:27
 */
public class DictAssembler {
    public static DictEntity toSaveEntity(DictSaveCmd cmd) {
        DictEntity entity = new DictEntity();
        entity.setId(cmd.getId());
        entity.setDictType(cmd.getType());
        entity.setTitle(cmd.getTitle());
        entity.setDescription(cmd.getDescription());
        entity.setSortOrder(cmd.getSortOrder());
        return entity;
    }

    public static DictVO toVo(DictEntity entity) {
        if(entity == null)return null;
        DictVO vo = new DictVO();
        vo.setId(entity.getId());
        vo.setType(entity.getDictType());
        vo.setTitle(entity.getTitle());
        vo.setDescription(entity.getDescription());
        vo.setSortOrder(entity.getSortOrder());
        return vo;
    }
}
