package com.xunheng.wechat.adapter.web;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.log.config.annotation.Log;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.wechat.client.api.WoaArticleService;
import com.xunheng.wechat.client.dto.VO.WoaArticleVO;
import com.xunheng.wechat.client.dto.query.WoaArticlePageQuery;
import com.xunheng.wechat.client.dto.WoaArticleSaveCmd;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import jakarta.annotation.Resource;

@Tag(name="公众号文章")
@RestResponse
@RequestMapping("/woaArticle")
public class WoaArticleController {

    @Resource
    WoaArticleService woaArticleService;

    @PermissionCode("wechat.woaArticle.pageList")
    @Log(module = "公众号文章",title = "公众号文章分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "公众号文章分页列表")
    public IPage<WoaArticleVO> getPageList(WoaArticlePageQuery query){
        return woaArticleService.pageList(query);
    }

    @PermissionCode("wechat.woaArticle.detail")
    @Log(module = "公众号文章",title = "公众号文章详情", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/getDetail/{id}",method = RequestMethod.GET)
    @Operation(summary = "公众号文章详情")
    public WoaArticleVO getDetail(@PathVariable String id){
        return woaArticleService.getDetail(id);
    }

    @PermissionCode("wechat.woaArticle.save")
    @Log(module = "公众号文章",title = "公众号文章保存", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "公众号文章保存")
    public WoaArticleVO save(@RequestBody @Validated WoaArticleSaveCmd cmd){
       return woaArticleService.save(cmd);
    }

    @PermissionCode("wechat.woaArticle.deleteBatch")
    @Log(module = "公众号文章",title = "公众号文章批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "公众号文章批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            woaArticleService.remove(id);
        }
         return "删除成功！";
    }
}