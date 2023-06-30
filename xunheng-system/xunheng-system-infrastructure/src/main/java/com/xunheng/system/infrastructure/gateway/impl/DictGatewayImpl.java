package com.xunheng.system.infrastructure.gateway.impl;

import com.alibaba.csp.sentinel.util.StringUtil;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.Dict;
import com.xunheng.system.infrastructure.convertor.DictConvertor;
import com.xunheng.system.domain.dict.model.DictEntity;
import com.xunheng.system.domain.dict.gateway.DictGateway;
import com.xunheng.system.infrastructure.mapper.DictMapper;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典网关实现类
 * @author: hhqkkr
 * @date: 2023/6/30 00:36
 */
@Slf4j
@Component
public class DictGatewayImpl implements DictGateway {

    @Resource
    DictMapper dictMapper;

    @Override
    public List<DictEntity> getAll() {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("sort_order");
        List<Dict> dicts = dictMapper.selectList(wrapper);
        return dicts.stream().map(DictConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public DictEntity getByType(String type) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        Dict dict = dictMapper.selectOne(wrapper);
        return DictConvertor.toEntity(dict);
    }

    @Override
    public DictEntity saveOrUpdate(DictEntity entity) {
        Dict dict = DictConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(dict.getId()) ? dictMapper.insert(dict) : dictMapper.updateById(dict);
        return DictConvertor.toEntity(dict);
    }

    @Override
    public void remove(String id) {
        dictMapper.deleteById(id);
    }

    @Override
    public Boolean checkExist(String type, String id) {
        QueryWrapper<Dict> wrapper = new QueryWrapper<>();
        wrapper.eq("type",type);
        if(StringUtil.isNotEmpty(id))wrapper.notIn("id",id);
        Dict dict = dictMapper.selectOne(wrapper);
        return dict != null;
    }
}
