package com.xunheng.wechat.infrastructure.convertor;

import com.xunheng.wechat.infrastructure.DO.WoaArticle;
import com.xunheng.wechat.domain.article.model.WoaArticleEntity;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章dto转换
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
public class WoaArticleConvertor {

    public static WoaArticle toDO(WoaArticleEntity entity) {
        if(entity == null)return null;
        WoaArticle woaArticle = new WoaArticle();
        woaArticle.setId(entity.getId());
        woaArticle.setType(entity.getType());
        woaArticle.setTitle(entity.getTitle());
        woaArticle.setTags(entity.getTags());
        woaArticle.setSummary(entity.getSummary());
        woaArticle.setContent(entity.getContent());
        woaArticle.setCategory(entity.getCategory());
        woaArticle.setSubCategory(entity.getSubCategory());
        woaArticle.setOpenCount(entity.getOpenCount());
        woaArticle.setTargetLink(entity.getTargetLink());
        woaArticle.setImage(entity.getImage());
        return woaArticle;
    }

    public static WoaArticleEntity toEntity(WoaArticle db) {
        if(db == null)return null;
        WoaArticleEntity entity = new WoaArticleEntity();
        entity.setId(db.getId());
        entity.setType(db.getType());
        entity.setTitle(db.getTitle());
        entity.setTags(db.getTags());
        entity.setSummary(db.getSummary());
        entity.setContent(db.getContent());
        entity.setCategory(db.getCategory());
        entity.setSubCategory(db.getSubCategory());
        entity.setOpenCount(db.getOpenCount());
        entity.setTargetLink(db.getTargetLink());
        entity.setImage(db.getImage());
        return entity;
    }
}
