package com.xunheng.wechat.app;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.wechat.client.api.WoaArticleService;
import com.xunheng.wechat.client.dto.query.WoaArticlePageQuery;
import com.xunheng.wechat.client.dto.WoaArticleSaveCmd;
import com.xunheng.wechat.client.dto.VO.WoaArticleVO;
import com.xunheng.wechat.app.executor.WoaArticleRemoveCmdExe;
import com.xunheng.wechat.app.executor.WoaArticleSaveCmdExe;
import com.xunheng.wechat.app.executor.query.WoaArticlePageQueryExe;
import com.xunheng.wechat.app.executor.query.WoaArticleDetailQueryExe;
import org.springframework.stereotype.Service;
import io.seata.spring.annotation.GlobalTransactional;
import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号文章service实现类
 * @author: hhqkkr
 * @date: 2023/12/01 13:06:45
 */
@Service
@GlobalTransactional
public class WoaArticleServiceImpl implements WoaArticleService {

    @Resource
    private WoaArticlePageQueryExe woaArticlePageQueryExe;

    @Resource
    private WoaArticleDetailQueryExe woaArticleDetailQueryExe;

    @Resource
    private WoaArticleSaveCmdExe woaArticleSaveCmdExe;

    @Resource
    private WoaArticleRemoveCmdExe woaArticleRemoveCmdExe;

    @Override
    public IPage<WoaArticleVO> pageList(WoaArticlePageQuery query){
        return woaArticlePageQueryExe.execute(query);
    }

    @Override
    public WoaArticleVO getDetail(String id) {
        return woaArticleDetailQueryExe.execute(id);
    }

    @Override
    public WoaArticleVO save(WoaArticleSaveCmd cmd) {
        return woaArticleSaveCmdExe.execute(cmd);
    }

    @Override
    public void remove(String id) {
        woaArticleRemoveCmdExe.execute(id);
    }

}