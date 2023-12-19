package com.xunheng.wechat.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.xunheng.wechat.infrastructure.DO.WoaArticle;
import com.xunheng.wechat.client.dto.query.WoaArticlePageQuery;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章数据层
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Repository
public interface WoaArticleMapper extends BaseMapper<WoaArticle> {

    /**
     * 获取公众号文章分页列表
     * @param page 分页配置
     * @param query 查询条件
     * @return 分页信息
     */
    IPage<WoaArticle> pageList(Page<WoaArticle> page, @Param("qry") WoaArticlePageQuery query);

}
