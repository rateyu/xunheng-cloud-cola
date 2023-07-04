package com.xunheng.generator.app.assembler;

import com.xunheng.generator.client.dto.GenConfigSaveAndGenCmd;
import com.xunheng.generator.client.dto.GenConfigSaveCmd;
import com.xunheng.generator.client.dto.VO.GenConfigVO;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
import com.xunheng.generator.domain.genConfig.model.GenType;
import io.seata.common.util.CollectionUtils;

import java.util.ArrayList;
import java.util.stream.Collectors;


/**
 * @program: xunheng-cloud-cola
 * @description: 代码生成配置dto转换
 * @author: hhqkkr
 * @date: 2023/7/3 17:13
 */
public class GenConfigAssembler {

    public static GenConfigEntity toSaveEntity(GenConfigSaveCmd cmd){
        GenConfigEntity entity = new GenConfigEntity();
        entity.setId(cmd.getId());
        entity.setType(GenType.valueOf(cmd.getType()));
        entity.setName(cmd.getName());
        entity.setDomainName(cmd.getDomainName());
        entity.setDescription(cmd.getDescription());
        entity.setAuthor(cmd.getAuthor());
        entity.setTablePrefix(cmd.getTablePrefix());
        entity.setTableAlias(cmd.getTableAlias());
        entity.setServiceName(cmd.getServiceName());
        if(CollectionUtils.isNotEmpty(cmd.getFieldList()))entity.setFieldList(cmd.getFieldList().stream().map(GenFieldConfigAssembler::toEntity).collect(Collectors.toList()));
        return entity;
    }

    public static GenConfigEntity toSaveAndGenEntity(GenConfigSaveAndGenCmd cmd){
        GenConfigEntity entity = new GenConfigEntity();
        entity.setId(cmd.getId());
        entity.setType(GenType.valueOf(cmd.getType()));
        entity.setName(cmd.getName());
        entity.setDomainName(cmd.getDomainName());
        entity.setDescription(cmd.getDescription());
        entity.setAuthor(cmd.getAuthor());
        entity.setTablePrefix(cmd.getTablePrefix());
        entity.setTableAlias(cmd.getTableAlias());
        entity.setServiceName(cmd.getServiceName());
        if(CollectionUtils.isNotEmpty(cmd.getFieldList()))entity.setFieldList(cmd.getFieldList().stream().map(GenFieldConfigAssembler::toEntity).collect(Collectors.toList()));
        /*配置一些需要生成的参数*/
        entity.setServicePackage(entity.getServicePackage());
        entity.setTableName(cmd.getTablePrefix(), cmd.getName());
        entity.setLowerCaseName(cmd.getName());
        return entity;
    }

    public static GenConfigVO toVo(GenConfigEntity entity){
        if(entity == null)return null;
        GenConfigVO vo = new GenConfigVO();
        vo.setId(entity.getId());
        vo.setType(entity.getType().name());
        vo.setName(entity.getName());
        vo.setDomainName(entity.getDomainName());
        vo.setDescription(entity.getDescription());
        vo.setAuthor(entity.getAuthor());
        vo.setTablePrefix(entity.getTablePrefix());
        vo.setTableAlias(entity.getTableAlias());
        vo.setServiceName(entity.getServiceName());
        if(CollectionUtils.isNotEmpty(entity.getFieldList()))vo.setFieldList(entity.getFieldList().stream().map(GenFieldConfigAssembler::toVO).collect(Collectors.toList()));
        else vo.setFieldList(new ArrayList<>());
        return vo;
    }
}
