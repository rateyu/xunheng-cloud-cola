package com.xunheng.file.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;
import com.xunheng.file.domain.uploadSetting.gateway.UploadSettingGateway;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;
import com.xunheng.file.infrastructure.DO.Catalogue;
import com.xunheng.file.infrastructure.DO.UploadSetting;
import com.xunheng.file.infrastructure.convertor.CatalogueConvertor;
import com.xunheng.file.infrastructure.convertor.UploadSettingConvertor;
import com.xunheng.file.infrastructure.mapper.UploadSettingMapper;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置网关实现类
 * @author: hhqkkr
 * @date: 2023/7/10 13:30
 */
@Component
public class UploadSettingGatewayImpl implements UploadSettingGateway {

    @Resource
    UploadSettingMapper uploadSettingMapper;

    @Override
    public IPage<UploadSettingEntity> pageList(UploadSettingPageQuery query) {
        IPage<UploadSetting> page = uploadSettingMapper.pageList(new Page<UploadSetting>(query.getPage(), query.getPageSize()), query);
        return page.convert(UploadSettingConvertor::toEntity);
    }

    @Override
    public UploadSettingEntity saveOrUpdate(UploadSettingEntity entity) {
        UploadSetting uploadSetting = UploadSettingConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(uploadSetting.getId()) ? uploadSettingMapper.insert(uploadSetting) : uploadSettingMapper.updateById(uploadSetting);
        return UploadSettingConvertor.toEntity(uploadSetting);
    }

    @Override
    public void remove(String id) {
        uploadSettingMapper.deleteById(id);
    }

    @Override
    public UploadSettingEntity getByCode(String code) {
        QueryWrapper<UploadSetting> wrapper = new QueryWrapper<>();
        wrapper.eq("code",code);
        UploadSetting setting = uploadSettingMapper.selectOne(wrapper);
        return UploadSettingConvertor.toEntity(setting);
    }
}
