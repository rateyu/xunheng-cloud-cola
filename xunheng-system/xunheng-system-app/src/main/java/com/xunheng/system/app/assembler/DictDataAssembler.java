package com.xunheng.system.app.assembler;

import com.xunheng.system.domain.dict.model.DictEntity;
import com.xunheng.system.domain.dict.model.DictDataEntity;
import com.xunheng.system.client.dto.DictDataSaveCmd;
import com.xunheng.system.client.dto.VO.DictDataVO;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据dto转换
 * @author: hhqkkr
 * @date: 2023/6/29 22:28
 */
public class DictDataAssembler {
    public static DictDataEntity toSaveEntity(DictDataSaveCmd cmd) {
        DictDataEntity entity = new DictDataEntity();
        entity.setId(cmd.getId());
        entity.setTitle(cmd.getTitle());
        entity.setValue(cmd.getValue());
        entity.setStatus(cmd.getStatus());
        entity.setDescription(cmd.getDescription());
        entity.setSortOrder(cmd.getSortOrder());
        entity.setDictEntity(new DictEntity(cmd.getDictId(),cmd.getDictTitle(),cmd.getType()));
        return entity;
    }

    public static DictDataVO toVo(DictDataEntity entity) {
        if(entity == null)return null;
        DictDataVO vo = new DictDataVO();
        vo.setId(entity.getId());
        vo.setTitle(entity.getTitle());
        vo.setValue(entity.getValue());
        vo.setStatus(entity.getStatus());
        vo.setDescription(entity.getDescription());
        vo.setSortOrder(entity.getSortOrder());
        if(entity.getDictEntity() != null)vo.setDictId(entity.getDictEntity().getId());
        if(entity.getDictEntity() != null)vo.setType(entity.getDictEntity().getDictType());
        if(entity.getDictEntity() != null)vo.setDictTitle(entity.getDictEntity().getTitle());
        return vo;
    }
}
