package com.xunheng.file.adapter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.file.client.api.UploadSettingService;
import com.xunheng.file.client.dto.UploadSettingSaveCmd;
import com.xunheng.file.client.dto.VO.UploadSettingVO;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;
import com.xunheng.log.config.annotation.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;


@Tag(name="上传设置")
@RestResponse
@RequestMapping("/uploadSetting")
public class UploadSettingController {

    @Resource
    UploadSettingService uploadSettingService;

    @PermissionCode("file.uploadSetting.pageList")
    @Log(module = "上传设置",title = "上传设置列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "上传设置列表")
    public IPage<UploadSettingVO> getPageList(UploadSettingPageQuery query){
        return uploadSettingService.pageList(query);
    }

    @PermissionCode("file.uploadSetting.add")
    @Log(module = "上传设置",title = "上传设置新增", businessType = BusinessType.ADD)
    @RequestMapping(value = "/save",method = RequestMethod.POST)
    @Operation(summary = "上传设置新增")
    public UploadSettingVO save(@RequestBody @Validated UploadSettingSaveCmd cmd){
        return uploadSettingService.saveOrUpdate(cmd);
    }

    @PermissionCode("file.uploadSetting.edit")
    @Log(module = "上传设置",title = "上传设置修改", businessType = BusinessType.EDIT)
    @RequestMapping(value = "/edit",method = RequestMethod.POST)
    @Operation(summary = "上传设置修改")
    public UploadSettingVO edit(@RequestBody @Validated UploadSettingSaveCmd cmd){
        return uploadSettingService.saveOrUpdate(cmd);
    }

    @PermissionCode("file.uploadSetting.deleteBatch")
    @Log(module = "上传设置",title = "上传设置批量删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "上传设置批量删除")
    public String delByIds(@PathVariable String[] ids){
        for(String id : ids){
            uploadSettingService.remove(id);
        }
        return "删除成功";
    }

}
