package com.xunheng.wechat.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.dto.VO.WoaArticleVO;
import com.xunheng.wechat.client.dto.query.WoaArticlePageQuery;
import com.xunheng.wechat.client.dto.WoaArticleSaveCmd;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章service
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
public interface WoaArticleService{

    /**
     * 公众号文章分页列表
     * @param query 分页查询dto
     * @return 分页信息
     */
    IPage<WoaArticleVO> pageList(WoaArticlePageQuery query);

    /**
     * 根据id获取单个详情
     * @param id 公众号文章id
     * @return 公众号文章信息
     */
    WoaArticleVO getDetail(String id);

    /**
     * 保存公众号文章信息
     * @param cmd 创建操作cmd
     * @return 公众号文章信息
     */
    WoaArticleVO save(WoaArticleSaveCmd cmd);

    /**
     * 根据id删除公众号文章
     * @param id 公众号文章id
     */
    void remove(String id);

}