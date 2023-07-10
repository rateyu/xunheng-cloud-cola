package com.xunheng.file.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.file.domain.catalogue.gateway.CatalogueGateway;
import com.xunheng.file.domain.catalogue.model.CatalogueEntity;
import com.xunheng.file.infrastructure.DO.Catalogue;
import com.xunheng.file.infrastructure.convertor.CatalogueConvertor;
import com.xunheng.file.infrastructure.mapper.CatalogueMapper;
import io.seata.common.util.StringUtils;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传目录网关实现类
 * @author: hhqkkr
 * @date: 2023/7/10 12:57
 */
@Component
public class CatalogueGatewayImpl implements CatalogueGateway {

    @Resource
    CatalogueMapper catalogueMapper;

    @Override
    public CatalogueEntity saveOrUpdate(CatalogueEntity entity) {
        Catalogue catalogue = CatalogueConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(catalogue.getId()) ? catalogueMapper.insert(catalogue) : catalogueMapper.updateById(catalogue);
        return CatalogueConvertor.toEntity(catalogue);
    }

    @Override
    public void remove(String id) {
        catalogueMapper.deleteById(id);
    }

    @Override
    public List<CatalogueEntity> allList() {
        QueryWrapper<Catalogue> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort_order");
        List<Catalogue> list = catalogueMapper.selectList(wrapper);
        return list.stream().map(CatalogueConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public CatalogueEntity getOne(String id) {
        Catalogue catalogue = catalogueMapper.selectById(id);
        return CatalogueConvertor.toEntity(catalogue);
    }
}
