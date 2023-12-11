package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaReplyRule;
import com.xunheng.wechat.infrastructure.convertor.WoaReplyRuleConvertor;
import com.xunheng.wechat.client.dto.query.WoaReplyRulePageQuery;
import com.xunheng.wechat.domain.customerService.gateway.WoaReplyRuleGateway;
import com.xunheng.wechat.infrastructure.mapper.WoaReplyRuleMapper;
import com.xunheng.wechat.domain.customerService.model.WoaReplyRuleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号回复规则网关实现类
 * @author: hhqkkr
 * @date: 2023/11/24 12:01:07
 */
@Slf4j
@Component
public class WoaReplyRuleGatewayImpl implements WoaReplyRuleGateway {

    @Resource
    WoaReplyRuleMapper woaReplyRuleMapper;

    @Override
    public IPage<WoaReplyRuleEntity> pageList(WoaReplyRulePageQuery query) {
        IPage<WoaReplyRule> page = woaReplyRuleMapper.pageList(new Page<WoaReplyRule>(query.getPage(), query.getPageSize()), query);
        return page.convert(WoaReplyRuleConvertor::toEntity);
    }

    @Override
    public WoaReplyRuleEntity getOneById(String id) {
        WoaReplyRule woaReplyRule = woaReplyRuleMapper.selectById(id);
        return WoaReplyRuleConvertor.toEntity(woaReplyRule);
    }

    @Override
    public WoaReplyRuleEntity saveOrUpdate(WoaReplyRuleEntity entity) {
        WoaReplyRule woaReplyRule = WoaReplyRuleConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(woaReplyRule.getId()) ? woaReplyRuleMapper.insert(woaReplyRule) : woaReplyRuleMapper.updateById(woaReplyRule);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WoaReplyRuleConvertor.toEntity(woaReplyRule);
    }

    @Override
    public WoaReplyRuleEntity create(WoaReplyRuleEntity entity) {
        WoaReplyRule woaReplyRule = WoaReplyRuleConvertor.toDO(entity);
        int count = woaReplyRuleMapper.insert(woaReplyRule);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WoaReplyRuleConvertor.toEntity(woaReplyRule);
    }

    @Override
    public WoaReplyRuleEntity update(WoaReplyRuleEntity entity) {
        WoaReplyRule woaReplyRule = WoaReplyRuleConvertor.toDO(entity);
        int count = woaReplyRuleMapper.updateById(woaReplyRule);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WoaReplyRuleConvertor.toEntity(woaReplyRule);
    }

    @Override
    public void remove(String id) {
        woaReplyRuleMapper.deleteById(id);
    }


}
