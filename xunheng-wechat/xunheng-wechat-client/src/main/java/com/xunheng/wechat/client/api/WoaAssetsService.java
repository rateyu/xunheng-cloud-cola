package com.xunheng.wechat.client.api;

import com.xunheng.wechat.client.dto.WoaAssetsImgTextUpdateCmd;
import com.xunheng.wechat.client.dto.WoaAssetsImgTextUploadCmd;
import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileRemoveCmd;
import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileUploadCmd;
import com.xunheng.wechat.client.dto.query.WoaImgTextPageQuery;
import com.xunheng.wechat.client.dto.query.WoaMaterialFilePageQuery;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialFileBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNewsBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;

/**
 * @program: xunheng-cloud-cola
 * @description: 公众号素材service
 * @author: hhqkkr
 * @date: 2023/07/25 12:10:16
 */
public interface WoaAssetsService {

    /**
     * 多媒体文件上传
     * @param cmd 上传参数
     * @return 上传结果
     */
    WxMpMaterialUploadResult materialFileUpload(WoaAssetsMaterialFileUploadCmd cmd);

    /**
     * 多媒体文件删除
     * @param cmd 删除参数
     * @return 删除结果
     */
    Boolean materialFileDelete(WoaAssetsMaterialFileRemoveCmd cmd);

    /**
     * 图文素材分页列表
     * @param query 分页查询条件
     * @return 结果
     */
    WxMpMaterialNewsBatchGetResult imgTextPageList(WoaImgTextPageQuery query);

    /**
     * 图文素材上传
     * @param cmd 上传参数
     * @return 上传结果
     */
    WxMpMaterialUploadResult imgTextUpload(WoaAssetsImgTextUploadCmd cmd);

    /**
     * 图文素材更新
     * @param cmd 更新参数
     */
    void imgTextUpdate(WoaAssetsImgTextUpdateCmd cmd);


    /**
     * 文件素材分页列表
     * @param query 分页查询列表
     * @return 分页结果
     */
    WxMpMaterialFileBatchGetResult materialFilePageList(WoaMaterialFilePageQuery query);

    /**
     * 图文素材详情
     * @param appId appId
     * @param mediaId 文件mediaId
     * @return 图文详情
     */
    WxMpMaterialNews getImgTextDetail(String appId, String mediaId);
}