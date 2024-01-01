package com.xunheng.wechat.adapter.web;

import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.wechat.client.api.WoaAssetsService;
import com.xunheng.wechat.client.dto.WoaAssetsImgTextUpdateCmd;
import com.xunheng.wechat.client.dto.WoaAssetsImgTextUploadCmd;
import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileRemoveCmd;
import com.xunheng.wechat.client.dto.WoaAssetsMaterialFileUploadCmd;
import com.xunheng.wechat.client.dto.query.WoaImgTextPageQuery;
import com.xunheng.wechat.client.dto.query.WoaMaterialFilePageQuery;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialFileBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNews;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialNewsBatchGetResult;
import me.chanjar.weixin.mp.bean.material.WxMpMaterialUploadResult;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;

@Tag(name="公众号素材")
@RestResponse
@RequestMapping("/woaAssets")
public class WoaAssetsController {

    @Resource
    WoaAssetsService woaAssetsService;

    @PermissionCode("wechat.woaAssets.add")
    @Log(module = "公众号素材",title = "公众号文件素材上传", businessType = BusinessType.ADD)
    @RequestMapping(value = "/materialFileUpload",method = RequestMethod.POST)
    @Operation(summary = "公众号文件素材上传")
    public WxMpMaterialUploadResult materialFileUpload(WoaAssetsMaterialFileUploadCmd cmd){
        return woaAssetsService.materialFileUpload(cmd);
    }

    @PermissionCode("wechat.woaAssets.delete")
    @Log(module = "公众号素材",title = "公众号文件素材删除", businessType = BusinessType.ADD)
    @RequestMapping(value = "/materialFileDelete",method = RequestMethod.POST)
    @Operation(summary = "公众号文件素材删除")
    public Boolean materialFileDelete(WoaAssetsMaterialFileRemoveCmd cmd){
        return woaAssetsService.materialFileDelete(cmd);
    }

    @PermissionCode("wechat.woaAssets.imgTextPageList")
    @Log(module = "公众号素材",title = "图文素材分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getImgTextPageList",method = RequestMethod.GET)
    @Operation(summary = "图文素材分页列表")
    public WxMpMaterialNewsBatchGetResult getImgTextPageList(WoaImgTextPageQuery query){
        return woaAssetsService.imgTextPageList(query);
    }

    @PermissionCode("wechat.woaAssets.materialFilePageList")
    @Log(module = "公众号素材",title = "文件素材分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getMaterialFilePageList",method = RequestMethod.GET)
    @Operation(summary = "文件素材分页列表")
    public WxMpMaterialFileBatchGetResult getMaterialFilePageList(WoaMaterialFilePageQuery query){
        return woaAssetsService.materialFilePageList(query);
    }

    @PermissionCode("wechat.woaAssets.detail")
    @Log(module = "公众号素材",title = "公众号图文素材详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getImgTextDetail/{appId}/{mediaId}",method = RequestMethod.GET)
    @Operation(summary = "公众号图文素材详情")
    public WxMpMaterialNews getImgTextDetail(@PathVariable String appId, @PathVariable String mediaId){
        return woaAssetsService.getImgTextDetail(appId,mediaId);
    }

    @PermissionCode("wechat.woaAssets.imgTextAdd")
    @Log(module = "公众号素材",title = "公众号图文素材添加", businessType = BusinessType.ADD)
    @RequestMapping(value = "/imgTextUpload",method = RequestMethod.POST)
    @Operation(summary = "公众号图文素材添加")
    public WxMpMaterialUploadResult imgTextUpload(WoaAssetsImgTextUploadCmd cmd){
        return woaAssetsService.imgTextUpload(cmd);
    }

    @PermissionCode("wechat.woaAssets.imgTextUpdate")
    @Log(module = "公众号素材",title = "公众号图文素材修改", businessType = BusinessType.ADD)
    @RequestMapping(value = "/imgTextUpdate",method = RequestMethod.POST)
    @Operation(summary = "公众号图文素材修改")
    public void imgTextEdit(WoaAssetsImgTextUpdateCmd cmd){
         woaAssetsService.imgTextUpdate(cmd);
    }


}