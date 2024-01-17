package com.xunheng.file.adapter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.annotation.RestResponse;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.file.client.api.FileService;
import com.xunheng.file.client.dto.FileUploadCmd;
import com.xunheng.file.client.dto.VO.FileUploadVO;
import com.xunheng.file.client.dto.VO.FileVO;
import com.xunheng.file.client.dto.query.FilePageQuery;
import com.xunheng.log.config.annotation.Log;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import jakarta.annotation.Resource;
import jakarta.servlet.http.HttpServletResponse;

@Tag(name="文件")
@RestResponse
@RequestMapping("/file")
public class FileController {

    @Resource
    FileService fileService;

    @PermissionCode("file.file.pageList")
    @Log(module = "文件",title = "文件分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @Operation(summary = "文件分页列表")
    public IPage<FileVO> getPageList(FilePageQuery query){
        return fileService.pageList(query);
    }

    @PermissionCode("file.file.delete")
    @Log(module = "文件",title = "文件删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @Operation(summary = "文件删除")
    public String deleteByIds(@PathVariable String[] ids){
        for (String id : ids) {
            fileService.remove(id);
        }
        return "删除文件成功";
    }

    @PermissionCode("file.file.upload")
    @Log(module = "文件",title = "文件上传", businessType = BusinessType.ADD)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @Operation(summary = "文件上传")
    public FileUploadVO upload(@Validated FileUploadCmd cmd) {
        return fileService.upload(cmd);
    }


    @PermissionCode("file.file.view")
    @Log(module = "文件",title = "文件本地查看", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/view/{id}/{fKey}", method = RequestMethod.GET)
    @Operation(summary = "文件本地查看")
    public void view(@PathVariable String id,HttpServletResponse response){
        fileService.view(id,response);
    }

}
