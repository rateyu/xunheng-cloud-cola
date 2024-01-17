package com.xunheng.file.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.file.client.dto.query.FilePageQuery;
import com.xunheng.file.domain.file.gateway.FileGateway;
import com.xunheng.file.domain.file.model.FileEntity;
import com.xunheng.file.infrastructure.DO.File;
import com.xunheng.file.infrastructure.DO.UploadSetting;
import com.xunheng.file.infrastructure.convertor.FileConvertor;
import com.xunheng.file.infrastructure.convertor.UploadSettingConvertor;
import com.xunheng.file.infrastructure.mapper.FileMapper;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件网关实现类
 * @author: hhqkkr
 * @date: 2023/7/10 17:08
 */
@Component
public class FileGatewayImpl implements FileGateway {

    @Resource
    FileMapper fileMapper;

    @Override
    public IPage<FileEntity> pageList(FilePageQuery query) {
        IPage<File> page = fileMapper.pageList(new Page<File>(query.getPage(), query.getPageSize()), query);
        return page.convert(FileConvertor::toEntity);
    }

    @Override
    public void remove(String id) {
        fileMapper.deleteById(id);
    }

    @Override
    public FileEntity create(FileEntity entity) {
        File file = FileConvertor.toDO(entity);
        int count =  fileMapper.insert(file);
        return FileConvertor.toEntity(file);
    }

    @Override
    public FileEntity getOne(String id) {
        File file = fileMapper.selectById(id);
        return FileConvertor.toEntity(file);
    }
}
