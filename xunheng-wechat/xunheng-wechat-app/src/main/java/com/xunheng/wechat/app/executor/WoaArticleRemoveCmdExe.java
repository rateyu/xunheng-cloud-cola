package com.xunheng.wechat.app.executor;

import com.xunheng.wechat.domain.article.gateway.WoaArticleGateway;
import org.springframework.stereotype.Component;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章删除操作处理器
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Component
public class WoaArticleRemoveCmdExe {

    @Resource
    private WoaArticleGateway woaArticleGateway;

    public void execute(String id) {
        woaArticleGateway.remove(id);
    }

}
