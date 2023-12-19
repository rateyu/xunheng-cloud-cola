package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WechatQrCode;
import com.xunheng.wechat.infrastructure.convertor.WechatQrCodeConvertor;
import com.xunheng.wechat.client.dto.query.WechatQrCodePageQuery;
import com.xunheng.wechat.domain.account.gateway.WechatQrCodeGateway;
import com.xunheng.wechat.infrastructure.mapper.WechatQrCodeMapper;
import com.xunheng.wechat.domain.account.model.WechatQrCodeEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 账号二维码信息网关实现类
 * @author: hhqkkr
 * @date: 2023/11/24 17:03:26
 */
@Slf4j
@Component
public class WechatQrCodeGatewayImpl implements WechatQrCodeGateway {

    @Resource
    WechatQrCodeMapper wechatQrCodeMapper;

    @Override
    public IPage<WechatQrCodeEntity> pageList(WechatQrCodePageQuery query) {
        IPage<WechatQrCode> page = wechatQrCodeMapper.pageList(new Page<WechatQrCode>(query.getPage(), query.getPageSize()), query);
        return page.convert(WechatQrCodeConvertor::toEntity);
    }

    @Override
    public WechatQrCodeEntity getOneById(String id) {
        WechatQrCode wechatQrCode = wechatQrCodeMapper.selectById(id);
        return WechatQrCodeConvertor.toEntity(wechatQrCode);
    }

    @Override
    public WechatQrCodeEntity saveOrUpdate(WechatQrCodeEntity entity) {
        WechatQrCode wechatQrCode = WechatQrCodeConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(wechatQrCode.getId()) ? wechatQrCodeMapper.insert(wechatQrCode) : wechatQrCodeMapper.updateById(wechatQrCode);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WechatQrCodeConvertor.toEntity(wechatQrCode);
    }

    @Override
    public WechatQrCodeEntity create(WechatQrCodeEntity entity) {
        WechatQrCode wechatQrCode = WechatQrCodeConvertor.toDO(entity);
        int count = wechatQrCodeMapper.insert(wechatQrCode);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WechatQrCodeConvertor.toEntity(wechatQrCode);
    }

    @Override
    public WechatQrCodeEntity update(WechatQrCodeEntity entity) {
        WechatQrCode wechatQrCode = WechatQrCodeConvertor.toDO(entity);
        int count = wechatQrCodeMapper.updateById(wechatQrCode);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WechatQrCodeConvertor.toEntity(wechatQrCode);
    }

    @Override
    public void remove(String id) {
        wechatQrCodeMapper.deleteById(id);
    }


}
