package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.conditions.query.QueryChainWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WechatAccount;
import com.xunheng.wechat.infrastructure.convertor.WechatAccountConvertor;
import com.xunheng.wechat.client.dto.query.WechatAccountPageQuery;
import com.xunheng.wechat.domain.wechatAccount.gateway.WechatAccountGateway;
import com.xunheng.wechat.infrastructure.mapper.WechatAccountMapper;
import com.xunheng.wechat.domain.wechatAccount.model.WechatAccountEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信开发帐号网关实现类
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
@Slf4j
@Component
public class WechatAccountGatewayImpl implements WechatAccountGateway {

    @Resource
    WechatAccountMapper wechatAccountMapper;

    @Override
    public IPage<WechatAccountEntity> pageList(WechatAccountPageQuery query) {
        IPage<WechatAccount> page = wechatAccountMapper.pageList(new Page<WechatAccount>(query.getPage(), query.getPageSize()), query);
        return page.convert(WechatAccountConvertor::toEntity);
    }

    @Override
    public List<WechatAccountEntity> allList() {
        List<WechatAccount> list = wechatAccountMapper.selectList(new QueryWrapper<>());
        return list.stream().map(WechatAccountConvertor::toEntity).collect(Collectors.toList());
    }

    @Override
    public WechatAccountEntity getOneById(String id) {
        WechatAccount wechatAccount = wechatAccountMapper.selectById(id);
        return WechatAccountConvertor.toEntity(wechatAccount);
    }

    @Override
    public WechatAccountEntity saveOrUpdate(WechatAccountEntity entity) {
        WechatAccount wechatAccount = WechatAccountConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(wechatAccount.getId()) ? wechatAccountMapper.insert(wechatAccount) : wechatAccountMapper.updateById(wechatAccount);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WechatAccountConvertor.toEntity(wechatAccount);
    }

    @Override
    public WechatAccountEntity create(WechatAccountEntity entity) {
        WechatAccount wechatAccount = WechatAccountConvertor.toDO(entity);
        int count = wechatAccountMapper.insert(wechatAccount);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WechatAccountConvertor.toEntity(wechatAccount);
    }

    @Override
    public WechatAccountEntity update(WechatAccountEntity entity) {
        WechatAccount wechatAccount = WechatAccountConvertor.toDO(entity);
        int count = wechatAccountMapper.updateById(wechatAccount);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WechatAccountConvertor.toEntity(wechatAccount);
    }

    @Override
    public void remove(String id) {
        wechatAccountMapper.deleteById(id);
    }


}
