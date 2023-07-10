package com.xunheng.file.app.assembler;

import com.xunheng.file.client.dto.UploadSettingSaveCmd;
import com.xunheng.file.client.dto.VO.UploadSettingVO;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置dto转换
 * @author: hhqkkr
 * @date: 2023/7/10 13:18
 */
public class UploadSettingAssembler {

    public static UploadSettingEntity toEntity(UploadSettingSaveCmd cmd){
        if(cmd == null)return null;
        UploadSettingEntity entity = new UploadSettingEntity();
        entity.setId(cmd.getId());
        entity.setTitle(cmd.getTitle());
        entity.setCode(cmd.getCode());
        entity.setCatalogueId(cmd.getCatalogueId());
        entity.setMaxSize(cmd.getMaxSize());
        entity.setLocation(cmd.getLocation());
        return entity;
    }


    public static UploadSettingVO toVO(UploadSettingEntity entity){
        if(entity == null)return null;
        UploadSettingVO vo = new UploadSettingVO();
        vo.setId(entity.getId());
        vo.setTitle(entity.getTitle());
        vo.setCode(entity.getCode());
        vo.setCatalogueId(entity.getCatalogueId());
        vo.setMaxSize(entity.getMaxSize());
        vo.setLocation(entity.getLocation());
        vo.setCatalogueTitle(entity.getCatalogueTitle());
        vo.setFullDir(entity.getFullDir());
        return vo;
    }

}
