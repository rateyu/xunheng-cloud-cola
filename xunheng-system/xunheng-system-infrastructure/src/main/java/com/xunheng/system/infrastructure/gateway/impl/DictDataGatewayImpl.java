package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.system.infrastructure.DO.DictData;
import com.xunheng.system.infrastructure.convertor.DictDataConvertor;
import com.xunheng.system.domain.dict.model.DictDataEntity;
import com.xunheng.system.client.dto.query.DictDataPageQuery;
import com.xunheng.system.domain.dict.gateway.DictDataGateway;
import com.xunheng.system.infrastructure.mapper.DictDataMapper;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 矩阵数据网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:36
 */
@Slf4j
@Component
public class DictDataGatewayImpl implements DictDataGateway {

    @Resource
    DictDataMapper dictDataMapper;

    @Override
    public IPage<DictDataEntity> pageList(DictDataPageQuery query) {
        IPage<DictData> page = dictDataMapper.pageList(new Page<DictData>(query.getPage(), query.getPageSize()), query);
        return page.convert(DictDataConvertor::toEntity);
    }

    @Override
    public List<DictDataEntity> getByDictId(String dictId) {
        QueryWrapper<DictData> wrapper = new QueryWrapper();
        wrapper.eq("dict_id",dictId);
        List<DictData> dictDatas = dictDataMapper.selectList(wrapper);
        return dictDatas.stream().map(DictDataConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public DictDataEntity saveOrUpdate(DictDataEntity entity) {
        DictData data = DictDataConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(data.getId()) ? dictDataMapper.insert(data) : dictDataMapper.updateById(data);
        return DictDataConvertor.toEntity(data);
    }

    @Override
    public void removeByDictId(String dictId) {
        Map<String,Object> map = new HashMap<>();
        map.put("dict_id",dictId);
        dictDataMapper.deleteByMap(map);
    }

    @Override
    public void remove(String id) {
        dictDataMapper.deleteById(id);
    }

    @Override
    public void updateStatus(String id, Integer status) {
        DictDataEntity entity = new DictDataEntity();
        entity.setId(id);
        entity.setStatus(status);
        dictDataMapper.updateById(DictDataConvertor.toDO(entity));
    }
}
