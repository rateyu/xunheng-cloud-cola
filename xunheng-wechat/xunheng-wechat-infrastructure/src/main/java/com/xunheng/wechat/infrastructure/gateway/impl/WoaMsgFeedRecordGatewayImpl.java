package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaMsgFeedRecord;
import com.xunheng.wechat.infrastructure.convertor.WoaMsgFeedRecordConvertor;
import com.xunheng.wechat.client.dto.query.WoaMsgFeedRecordPageQuery;
import com.xunheng.wechat.domain.msgFeed.gateway.WoaMsgFeedRecordGateway;
import com.xunheng.wechat.infrastructure.mapper.WoaMsgFeedRecordMapper;
import com.xunheng.wechat.domain.msgFeed.model.WoaMsgFeedRecordEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 消息推送日志网关实现类
 * @author: hhqkkr
 * @date: 2023/11/24 17:38:58
 */
@Slf4j
@Component
public class WoaMsgFeedRecordGatewayImpl implements WoaMsgFeedRecordGateway {

    @Resource
    WoaMsgFeedRecordMapper woaMsgFeedRecordMapper;

    @Override
    public IPage<WoaMsgFeedRecordEntity> pageList(WoaMsgFeedRecordPageQuery query) {
        IPage<WoaMsgFeedRecord> page = woaMsgFeedRecordMapper.pageList(new Page<WoaMsgFeedRecord>(query.getPage(), query.getPageSize()), query);
        return page.convert(WoaMsgFeedRecordConvertor::toEntity);
    }

    @Override
    public WoaMsgFeedRecordEntity getOneById(String id) {
        WoaMsgFeedRecord woaMsgFeedRecord = woaMsgFeedRecordMapper.selectById(id);
        return WoaMsgFeedRecordConvertor.toEntity(woaMsgFeedRecord);
    }

    @Override
    public WoaMsgFeedRecordEntity saveOrUpdate(WoaMsgFeedRecordEntity entity) {
        WoaMsgFeedRecord woaMsgFeedRecord = WoaMsgFeedRecordConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(woaMsgFeedRecord.getId()) ? woaMsgFeedRecordMapper.insert(woaMsgFeedRecord) : woaMsgFeedRecordMapper.updateById(woaMsgFeedRecord);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WoaMsgFeedRecordConvertor.toEntity(woaMsgFeedRecord);
    }

    @Override
    public WoaMsgFeedRecordEntity create(WoaMsgFeedRecordEntity entity) {
        WoaMsgFeedRecord woaMsgFeedRecord = WoaMsgFeedRecordConvertor.toDO(entity);
        int count = woaMsgFeedRecordMapper.insert(woaMsgFeedRecord);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WoaMsgFeedRecordConvertor.toEntity(woaMsgFeedRecord);
    }

    @Override
    public WoaMsgFeedRecordEntity update(WoaMsgFeedRecordEntity entity) {
        WoaMsgFeedRecord woaMsgFeedRecord = WoaMsgFeedRecordConvertor.toDO(entity);
        int count = woaMsgFeedRecordMapper.updateById(woaMsgFeedRecord);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WoaMsgFeedRecordConvertor.toEntity(woaMsgFeedRecord);
    }

    @Override
    public void remove(String id) {
        woaMsgFeedRecordMapper.deleteById(id);
    }


}
