package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaFans;
import com.xunheng.wechat.infrastructure.convertor.WoaFansConvertor;
import com.xunheng.wechat.client.dto.query.WoaFansPageQuery;
import com.xunheng.wechat.domain.fans.gateway.WoaFansGateway;
import com.xunheng.wechat.infrastructure.mapper.WoaFansMapper;
import com.xunheng.wechat.domain.fans.model.WoaFansEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号粉丝网关实现类
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WoaFansGatewayImpl implements WoaFansGateway {

    @Resource
    WoaFansMapper woaFansMapper;

    @Override
    public IPage<WoaFansEntity> pageList(WoaFansPageQuery query) {
        IPage<WoaFans> page = woaFansMapper.pageList(new Page<WoaFans>(query.getPage(), query.getPageSize()), query);
        return page.convert(WoaFansConvertor::toEntity);
    }

    @Override
    public WoaFansEntity getOneById(String id) {
        WoaFans woaFans = woaFansMapper.selectById(id);
        return WoaFansConvertor.toEntity(woaFans);
    }

    @Override
    public WoaFansEntity getOneByOpenId(String openId) {
        QueryWrapper<WoaFans> wrapper = new QueryWrapper<>();
        wrapper.eq("del_flag",0);
        wrapper.eq("open_id",openId);
        WoaFans woaFans = woaFansMapper.selectOne(wrapper);
        return WoaFansConvertor.toEntity(woaFans);
    }

    @Override
    public WoaFansEntity saveOrUpdate(WoaFansEntity entity) {
        WoaFans woaFans = WoaFansConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(woaFans.getId()) ? woaFansMapper.insert(woaFans) : woaFansMapper.updateById(woaFans);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WoaFansConvertor.toEntity(woaFans);
    }

    @Override
    public WoaFansEntity create(WoaFansEntity entity) {
        WoaFans woaFans = WoaFansConvertor.toDO(entity);
        int count = woaFansMapper.insert(woaFans);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WoaFansConvertor.toEntity(woaFans);
    }

    @Override
    public WoaFansEntity update(WoaFansEntity entity) {
        WoaFans woaFans = WoaFansConvertor.toDO(entity);
        int count = woaFansMapper.updateById(woaFans);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WoaFansConvertor.toEntity(woaFans);
    }

    @Override
    public void remove(String id) {
        woaFansMapper.deleteById(id);
    }


}
