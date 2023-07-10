package com.xunheng.file.app.assembler;

import com.xunheng.file.client.dto.FileUploadCmd;
import com.xunheng.file.client.dto.VO.FileVO;
import com.xunheng.file.domain.file.model.FileEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件dto转换
 * @author: hhqkkr
 * @date: 2023/7/10 13:18
 */
public class FileAssembler {

    public static FileVO toVO(FileEntity entity){
        if(entity == null)return null;
        FileVO vo = new FileVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setFKey(entity.getFKey());
        vo.setSize(entity.getSize());
        vo.setType(entity.getType());
        vo.setUrl(entity.getUrl());
        vo.setCatalogueId(entity.getCatalogueId());
        vo.setSettingId(entity.getSettingId());
        vo.setMainId(entity.getMainId());
        vo.setNickname(entity.getNickname());
        vo.setLocation(entity.getLocation());
        return vo;
    }

}
