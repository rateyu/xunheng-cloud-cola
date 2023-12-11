package com.xunheng.wechat.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.app.assembler.WoaArticleAssembler;
import com.xunheng.wechat.client.dto.query.WoaArticlePageQuery;
import com.xunheng.wechat.client.dto.VO.WoaArticleVO;
import com.xunheng.wechat.domain.article.gateway.WoaArticleGateway;
import com.xunheng.wechat.domain.article.model.WoaArticleEntity;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章分页查询处理器
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Component
public class WoaArticlePageQueryExe {

    @Resource
    WoaArticleGateway woaArticleGateway;

    public IPage<WoaArticleVO> execute(WoaArticlePageQuery query) {
        IPage<WoaArticleEntity> page = woaArticleGateway.pageList(query);
        return page.convert(WoaArticleAssembler::toVo);
    }
}
