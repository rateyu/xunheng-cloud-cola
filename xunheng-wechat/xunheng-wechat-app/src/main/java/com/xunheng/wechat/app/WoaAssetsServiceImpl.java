package com.xunheng.wechat.app;

import com.xunheng.wechat.app.executor.WoaAssetsImgTextUpdateCmdExe;
import com.xunheng.wechat.app.executor.WoaAssetsImgTextUploadCmdExe;
import com.xunheng.wechat.app.executor.WoaAssetsMaterialFileRemoveCmdExe;
import com.xunheng.wechat.app.executor.WoaAssetsMaterialFileUploadCmdExe;
import com.xunheng.wechat.app.executor.query.WoaAssetsImgTextDetailQueryExe;
import com.xunheng.wechat.app.executor.query.WoaAssetsImgTextPageQueryExe;
import com.xunheng.wechat.app.executor.query.WoaAssetsMaterialFilePageQueryExe;
import com.xunheng.wechat.client.api.WoaAssetsService;
import com.xunheng.wechat.client.dto.WoaAssetsImgTextUpdateCmd;
import com.xunheng.wechat.client.dto.WoaAssetsImgTextUploadCmd;
import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileRemoveCmd;
import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileUploadCmd;
import com.xunheng.wechat.client.dto.query.WoaImgTextPageQuery;
import com.xunheng.wechat.client.dto.query.WoaMaterialFilePageQuery;
import io.seata.spring.annotation.GlobalTransactional;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialFileBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNewsBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号素材service实现类
 * @author: hhqkkr
 * @date: 2023/11/22 12:16:19
 */
@Service
@GlobalTransactional
public class WoaAssetsServiceImpl implements WoaAssetsService {

    @Resource
    private WoaAssetsMaterialFileUploadCmdExe woaAssetsMaterialFileUploadCmdExe;

    @Resource
    private WoaAssetsMaterialFileRemoveCmdExe woaAssetsMaterialFileRemoveCmdExe;

    @Resource
    private WoaAssetsImgTextPageQueryExe woaImgTextPageQueryExe;

    @Resource
    private WoaAssetsMaterialFilePageQueryExe woaAssetsMaterialFilePageQueryExe;

    @Resource
    private WoaAssetsImgTextUploadCmdExe woaAssetsImgTextUploadCmdExe;

    @Resource
    private WoaAssetsImgTextUpdateCmdExe woaAssetsImgTextUpdateCmdExe;

    @Resource
    private WoaAssetsImgTextDetailQueryExe woaAssetsImgTextDetailQueryExe;


    @Override
    public WxMpMaterialUploadResult materialFileUpload(WoaAssetsMaterialFileUploadCmd cmd) {
        return woaAssetsMaterialFileUploadCmdExe.execute(cmd);
    }

    @Override
    public Boolean materialFileDelete(WoaAssetsMaterialFileRemoveCmd cmd) {
        return woaAssetsMaterialFileRemoveCmdExe.execute(cmd);
    }

    @Override
    public WxMpMaterialNewsBatchGetResult imgTextPageList(WoaImgTextPageQuery query) {
        return woaImgTextPageQueryExe.execute(query);
    }

    @Override
    public WxMpMaterialUploadResult imgTextUpload(WoaAssetsImgTextUploadCmd cmd) {
        return woaAssetsImgTextUploadCmdExe.execute(cmd);
    }

    @Override
    public void imgTextUpdate(WoaAssetsImgTextUpdateCmd cmd) {
             woaAssetsImgTextUpdateCmdExe.execute(cmd);
    }

    @Override
    public WxMpMaterialFileBatchGetResult materialFilePageList(WoaMaterialFilePageQuery query) {
        return woaAssetsMaterialFilePageQueryExe.execute(query);
    }

    @Override
    public WxMpMaterialNews getImgTextDetail(String appId, String mediaId) {
        return woaAssetsImgTextDetailQueryExe.execute(appId,mediaId);
    }
}