package com.xunheng.wechat.app.executor.query;

import com.xunheng.wechat.app.assembler.WoaArticleAssembler;
import com.xunheng.wechat.client.dto.VO.WoaArticleVO;
import com.xunheng.wechat.domain.article.gateway.WoaArticleGateway;
import org.springframework.stereotype.Component;
import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章详情查询处理器
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Component
public class WoaArticleDetailQueryExe {
    @Resource
    WoaArticleGateway woaArticleGateway;

    public WoaArticleVO execute(String id) {
        return WoaArticleAssembler.toVo(woaArticleGateway.getOneById(id));
    }
}

