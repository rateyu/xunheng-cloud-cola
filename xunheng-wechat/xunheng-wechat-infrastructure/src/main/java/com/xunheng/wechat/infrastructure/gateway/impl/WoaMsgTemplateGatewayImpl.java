package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaMsgTemplate;
import com.xunheng.wechat.infrastructure.convertor.WoaMsgTemplateConvertor;
import com.xunheng.wechat.client.dto.query.WoaMsgTemplatePageQuery;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgTemplateGateway;
import com.xunheng.wechat.infrastructure.mapper.WoaMsgTemplateMapper;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgTemplateEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送模板网关实现类
 * @author: hhqkkr
 * @date: 2023/11/24 17:36:33
 */
@Slf4j
@Component
public class WoaMsgTemplateGatewayImpl implements WoaMsgTemplateGateway {

    @Resource
    WoaMsgTemplateMapper woaMsgTemplateMapper;

    @Override
    public IPage<WoaMsgTemplateEntity> pageList(WoaMsgTemplatePageQuery query) {
        IPage<WoaMsgTemplate> page = woaMsgTemplateMapper.pageList(new Page<WoaMsgTemplate>(query.getPage(), query.getPageSize()), query);
        return page.convert(WoaMsgTemplateConvertor::toEntity);
    }

    @Override
    public WoaMsgTemplateEntity getOneById(String id) {
        WoaMsgTemplate woaMsgTemplate = woaMsgTemplateMapper.selectById(id);
        return WoaMsgTemplateConvertor.toEntity(woaMsgTemplate);
    }

    @Override
    public WoaMsgTemplateEntity saveOrUpdate(WoaMsgTemplateEntity entity) {
        WoaMsgTemplate woaMsgTemplate = WoaMsgTemplateConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(woaMsgTemplate.getId()) ? woaMsgTemplateMapper.insert(woaMsgTemplate) : woaMsgTemplateMapper.updateById(woaMsgTemplate);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WoaMsgTemplateConvertor.toEntity(woaMsgTemplate);
    }

    @Override
    public WoaMsgTemplateEntity create(WoaMsgTemplateEntity entity) {
        WoaMsgTemplate woaMsgTemplate = WoaMsgTemplateConvertor.toDO(entity);
        int count = woaMsgTemplateMapper.insert(woaMsgTemplate);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WoaMsgTemplateConvertor.toEntity(woaMsgTemplate);
    }

    @Override
    public WoaMsgTemplateEntity update(WoaMsgTemplateEntity entity) {
        WoaMsgTemplate woaMsgTemplate = WoaMsgTemplateConvertor.toDO(entity);
        int count = woaMsgTemplateMapper.updateById(woaMsgTemplate);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WoaMsgTemplateConvertor.toEntity(woaMsgTemplate);
    }

    @Override
    public void remove(String id) {
        woaMsgTemplateMapper.deleteById(id);
    }


}
