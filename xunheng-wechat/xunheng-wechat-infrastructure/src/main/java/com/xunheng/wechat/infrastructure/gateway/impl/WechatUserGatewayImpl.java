package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WechatUser;
import com.xunheng.wechat.infrastructure.convertor.WechatUserConvertor;
import com.xunheng.wechat.client.dto.query.WechatUserPageQuery;
import com.xunheng.wechat.domain.wechatUser.gateway.WechatUserGateway;
import com.xunheng.wechat.infrastructure.mapper.WechatUserMapper;
import com.xunheng.wechat.domain.wechatUser.model.WechatUserEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 微信用户网关实现类
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Slf4j
@Component
public class WechatUserGatewayImpl implements WechatUserGateway {

    @Resource
    WechatUserMapper wechatUserMapper;

    @Override
    public IPage<WechatUserEntity> pageList(WechatUserPageQuery query) {
        IPage<WechatUser> page = wechatUserMapper.pageList(new Page<WechatUser>(query.getPage(), query.getPageSize()), query);
        return page.convert(WechatUserConvertor::toEntity);
    }

    @Override
    public WechatUserEntity getOneById(String id) {
        WechatUser wechatUser = wechatUserMapper.selectById(id);
        return WechatUserConvertor.toEntity(wechatUser);
    }

    @Override
    public WechatUserEntity getOneByOpenId(String appId,String openId) {
        QueryWrapper<WechatUser> wrapper = new QueryWrapper<>();
        wrapper.eq("app_id",appId);
        wrapper.eq("open_id",openId);
        WechatUser wechatUser = wechatUserMapper.selectOne(wrapper);
        return WechatUserConvertor.toEntity(wechatUser);
    }

    @Override
    public WechatUserEntity saveOrUpdate(WechatUserEntity entity) {
        WechatUser wechatUser = WechatUserConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(wechatUser.getId()) ? wechatUserMapper.insert(wechatUser) : wechatUserMapper.updateById(wechatUser);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WechatUserConvertor.toEntity(wechatUser);
    }

    @Override
    public WechatUserEntity create(WechatUserEntity entity) {
        WechatUser wechatUser = WechatUserConvertor.toDO(entity);
        int count = wechatUserMapper.insert(wechatUser);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WechatUserConvertor.toEntity(wechatUser);
    }

    @Override
    public WechatUserEntity update(WechatUserEntity entity) {
        WechatUser wechatUser = WechatUserConvertor.toDO(entity);
        int count = wechatUserMapper.updateById(wechatUser);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WechatUserConvertor.toEntity(wechatUser);
    }

    @Override
    public void remove(String id) {
        wechatUserMapper.deleteById(id);
    }


}
