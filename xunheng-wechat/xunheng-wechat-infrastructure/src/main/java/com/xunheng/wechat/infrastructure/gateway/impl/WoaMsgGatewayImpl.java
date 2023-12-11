package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaMsg;
import com.xunheng.wechat.infrastructure.convertor.WoaMsgConvertor;
import com.xunheng.wechat.client.dto.query.WoaMsgPageQuery;
import com.xunheng.wechat.domain.customerService.gateway.WoaMsgGateway;
import com.xunheng.wechat.infrastructure.mapper.WoaMsgMapper;
import com.xunheng.wechat.domain.customerService.model.WoaMsgEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号消息网关实现类
 * @author: hhqkkr
 * @date: 2023/11/24 14:19:41
 */
@Slf4j
@Component
public class WoaMsgGatewayImpl implements WoaMsgGateway {

    @Resource
    WoaMsgMapper woaMsgMapper;

    @Override
    public IPage<WoaMsgEntity> pageList(WoaMsgPageQuery query) {
        IPage<WoaMsg> page = woaMsgMapper.pageList(new Page<WoaMsg>(query.getPage(), query.getPageSize()), query);
        return page.convert(WoaMsgConvertor::toEntity);
    }

    @Override
    public WoaMsgEntity getOneById(String id) {
        WoaMsg woaMsg = woaMsgMapper.selectById(id);
        return WoaMsgConvertor.toEntity(woaMsg);
    }

    @Override
    public WoaMsgEntity saveOrUpdate(WoaMsgEntity entity) {
        WoaMsg woaMsg = WoaMsgConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(woaMsg.getId()) ? woaMsgMapper.insert(woaMsg) : woaMsgMapper.updateById(woaMsg);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WoaMsgConvertor.toEntity(woaMsg);
    }

    @Override
    public WoaMsgEntity create(WoaMsgEntity entity) {
        WoaMsg woaMsg = WoaMsgConvertor.toDO(entity);
        int count = woaMsgMapper.insert(woaMsg);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WoaMsgConvertor.toEntity(woaMsg);
    }

    @Override
    public WoaMsgEntity update(WoaMsgEntity entity) {
        WoaMsg woaMsg = WoaMsgConvertor.toDO(entity);
        int count = woaMsgMapper.updateById(woaMsg);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WoaMsgConvertor.toEntity(woaMsg);
    }

    @Override
    public void remove(String id) {
        woaMsgMapper.deleteById(id);
    }


}
