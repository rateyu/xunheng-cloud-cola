package com.xunheng.system.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.system.infrastructure.DO.CustomConfig;
import com.xunheng.system.infrastructure.convertor.CustomConfigConvertor;
import com.xunheng.system.client.dto.query.CustomConfigQuery;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;
import com.xunheng.system.domain.customConfig.gateway.CustomConfigGateway;
import com.xunheng.system.infrastructure.mapper.CustomConfigMapper;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 个性化配置网关实现
 * @author: hhqkkr
 * @date: 2023/6/30 00:37
 */
@Slf4j
@Component
public class CustomConfigGatewayImpl implements CustomConfigGateway {

    @Resource
    CustomConfigMapper customConfigMapper;

    @Override
    public CustomConfigEntity saveOrUpdate(CustomConfigEntity entity) {
        CustomConfig customConfig = CustomConfigConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(customConfig.getId()) ? customConfigMapper.insert(customConfig) : customConfigMapper.updateById(customConfig);
        return CustomConfigConvertor.toEntity(customConfig);
    }

    @Override
    public CustomConfigEntity getOne(CustomConfigQuery query) {
        QueryWrapper wrapper = new QueryWrapper();
        wrapper.eq("user_id", query.getUserId());
        wrapper.eq("config_key", query.getConfigKey());
        CustomConfig one = customConfigMapper.selectOne(wrapper);
        return CustomConfigConvertor.toEntity(one);
    }

    @Override
    public List<CustomConfigEntity> getSystemConfigList() {
        QueryWrapper<CustomConfig> wrapper = new QueryWrapper();
        wrapper.eq("user_id","-1");
        wrapper.eq("personal",0);
        List<CustomConfig> customConfigs = customConfigMapper.selectList(wrapper);
        return customConfigs.stream().map(CustomConfigConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public List<CustomConfigEntity> getPersonalConfigsByUserId(String userId) {
        QueryWrapper<CustomConfig> wrapper = new QueryWrapper();
        wrapper.eq("user_id",userId);
        wrapper.eq("personal",1);
        List<CustomConfig> customConfigs = customConfigMapper.selectList(wrapper);
        return customConfigs.stream().map(CustomConfigConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public void remove(String id) {
        customConfigMapper.deleteById(id);
    }

    @Override
    public CustomConfigEntity savePersonalConfig(CustomConfigEntity entity) {
        //确认有没有已经存在的配置
        CustomConfigQuery query = new CustomConfigQuery();
        query.setUserId(entity.getUserId());
        query.setConfigKey(entity.getConfigKey());
        CustomConfigEntity one = this.getOne(query);
        if(one != null)entity.setId(one.getId());
        //保存
        return this.saveOrUpdate(entity);
    }
}
