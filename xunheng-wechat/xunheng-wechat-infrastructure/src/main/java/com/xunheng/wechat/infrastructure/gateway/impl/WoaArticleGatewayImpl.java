package com.xunheng.wechat.infrastructure.gateway.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaArticle;
import com.xunheng.wechat.infrastructure.convertor.WoaArticleConvertor;
import com.xunheng.wechat.client.dto.query.WoaArticlePageQuery;
import com.xunheng.wechat.domain.article.gateway.WoaArticleGateway;
import com.xunheng.wechat.infrastructure.mapper.WoaArticleMapper;
import com.xunheng.wechat.domain.article.model.WoaArticleEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;
import com.xunheng.base.exception.GlobalException;
import com.mysql.cj.util.StringUtils;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章网关实现类
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Slf4j
@Component
public class WoaArticleGatewayImpl implements WoaArticleGateway {

    @Resource
    WoaArticleMapper woaArticleMapper;

    @Override
    public IPage<WoaArticleEntity> pageList(WoaArticlePageQuery query) {
        IPage<WoaArticle> page = woaArticleMapper.pageList(new Page<WoaArticle>(query.getPage(), query.getPageSize()), query);
        return page.convert(WoaArticleConvertor::toEntity);
    }

    @Override
    public WoaArticleEntity getOneById(String id) {
        WoaArticle woaArticle = woaArticleMapper.selectById(id);
        return WoaArticleConvertor.toEntity(woaArticle);
    }

    @Override
    public WoaArticleEntity saveOrUpdate(WoaArticleEntity entity) {
        WoaArticle woaArticle = WoaArticleConvertor.toDO(entity);
        int count = StringUtils.isNullOrEmpty(woaArticle.getId()) ? woaArticleMapper.insert(woaArticle) : woaArticleMapper.updateById(woaArticle);
        if(count < 1)throw new GlobalException("Gateway保存或更新数据失败");
        return WoaArticleConvertor.toEntity(woaArticle);
    }

    @Override
    public WoaArticleEntity create(WoaArticleEntity entity) {
        WoaArticle woaArticle = WoaArticleConvertor.toDO(entity);
        int count = woaArticleMapper.insert(woaArticle);
        if(count < 1)throw new GlobalException("Gateway创建数据失败");
        return WoaArticleConvertor.toEntity(woaArticle);
    }

    @Override
    public WoaArticleEntity update(WoaArticleEntity entity) {
        WoaArticle woaArticle = WoaArticleConvertor.toDO(entity);
        int count = woaArticleMapper.updateById(woaArticle);
        if(count < 1)throw new GlobalException("Gateway更新数据失败");
        return WoaArticleConvertor.toEntity(woaArticle);
    }

    @Override
    public void remove(String id) {
        woaArticleMapper.deleteById(id);
    }

    @Override
    public Boolean checkCategoryArticleExist(WoaArticleEntity article) {
        QueryWrapper<WoaArticle> wrapper = new QueryWrapper<WoaArticle>().eq("title", article.getTitle())
                .eq("category", article.getCategory())
                .eq("sub_category", article.getSubCategory());
        if(!StringUtils.isNullOrEmpty(article.getId()))wrapper.eq("id",article.getId());
        return woaArticleMapper.selectCount(wrapper) > 0;
    }

}
