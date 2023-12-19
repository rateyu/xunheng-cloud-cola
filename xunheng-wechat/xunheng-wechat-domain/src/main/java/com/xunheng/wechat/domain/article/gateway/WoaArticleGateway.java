package com.xunheng.wechat.domain.article.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.domain.article.model.WoaArticleEntity;
import com.xunheng.wechat.client.dto.query.WoaArticlePageQuery;

/**
 * @program: xunheng-cloud-cola
 * @description: WoaArticle网关
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
public interface WoaArticleGateway {

    /**
     * 公众号文章分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaArticleEntity> pageList(WoaArticlePageQuery query);

    /**
     * 根据id获取公众号文章信息
     * @param id 公众号文章id
     * @return 公众号文章实体
     */
    WoaArticleEntity getOneById(String id);

    /**
     * 保存或更新公众号文章实体
     * @param entity 公众号文章实体
     * @return 公众号文章实体
     */
    WoaArticleEntity saveOrUpdate(WoaArticleEntity entity);

    /**
     * 创建公众号文章实体
     * @param entity 公众号文章实体
     * @return 公众号文章实体
     */
    WoaArticleEntity create(WoaArticleEntity entity);

    /**
     * 更新公众号文章实体
     * @param entity 公众号文章实体
     * @return 公众号文章实体
     */
    WoaArticleEntity update(WoaArticleEntity entity);

    /**
     * 根据id删除公众号文章
     * @param id 公众号文章id
     */
    void remove(String id);

    /**
     * 查看同目录下有没有相同名称的文章
     * @param article 文章
     * @return 是否有
     */
    Boolean checkCategoryArticleExist(WoaArticleEntity article);
}
