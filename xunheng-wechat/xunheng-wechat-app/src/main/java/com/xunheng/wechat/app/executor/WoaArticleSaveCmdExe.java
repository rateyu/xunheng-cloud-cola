package com.xunheng.wechat.app.executor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.wechat.app.assembler.WoaArticleAssembler;
import com.xunheng.wechat.client.dto.WoaArticleSaveCmd;
import com.xunheng.wechat.client.dto.VO.WoaArticleVO;
import com.xunheng.wechat.domain.article.gateway.WoaArticleGateway;
import com.xunheng.wechat.domain.article.model.WoaArticleEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章创建处理器
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Component
public class WoaArticleSaveCmdExe {

    @Resource
    private WoaArticleGateway woaArticleGateway;

    private static final String ID_PLACEHOLDER = "${articleId}";

    public WoaArticleVO execute(WoaArticleSaveCmd cmd) {
        /*转换实体*/
        WoaArticleEntity article = WoaArticleAssembler.toSaveEntity(cmd);
        /*检查是否存在相同文章*/
        if (woaArticleGateway.checkCategoryArticleExist(article))throw new GlobalException("同目录下文章[" + article.getTitle() + "]已存在，不可重复添加");
        /*保存更新实体*/
        woaArticleGateway.saveOrUpdate(article);
        /*替换链接*/
        String targetLink = article.getTargetLink();
        if (targetLink.contains(ID_PLACEHOLDER)) {
            article.setTargetLink(targetLink.replace(ID_PLACEHOLDER, article.getId()));
            woaArticleGateway.saveOrUpdate(article);
        }
        return WoaArticleAssembler.toVo(article);
    }

}
