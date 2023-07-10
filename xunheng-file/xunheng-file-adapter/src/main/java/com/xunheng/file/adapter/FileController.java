package com.xunheng.file.adapter;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.annotation.PermissionCode;
import com.xunheng.base.enums.BusinessType;
import com.xunheng.file.client.api.FileService;
import com.xunheng.file.client.dto.FileUploadCmd;
import com.xunheng.file.client.dto.VO.FileUploadVO;
import com.xunheng.file.client.dto.VO.FileVO;
import com.xunheng.file.client.dto.query.FilePageQuery;
import com.xunheng.log.config.annotation.Log;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

@Api("文件")
@RestController
@RequestMapping("/file")
public class FileController {

    @Resource
    FileService fileService;

    @PermissionCode("file.file.pageList")
    @Log(module = "文件",title = "文件分页列表", businessType = BusinessType.LIST)
    @RequestMapping(value = "/getPageList",method = RequestMethod.GET)
    @ApiOperation(value = "文件分页列表")
    public IPage<FileVO> getPageList(FilePageQuery query){
        return fileService.pageList(query);
    }

    @PermissionCode("file.file.delete")
    @Log(module = "文件",title = "文件删除", businessType = BusinessType.DELETE)
    @RequestMapping(value = "/delByIds/{ids}",method = RequestMethod.DELETE)
    @ApiOperation(value = "文件删除")
    public String deleteByIds(@PathVariable String[] ids){
        for (String id : ids) {
            fileService.remove(id);
        }
        return "删除文件成功";
    }

    @PermissionCode("file.file.upload")
    @Log(module = "文件",title = "文件上传", businessType = BusinessType.ADD)
    @RequestMapping(value = "/upload", method = RequestMethod.POST)
    @ApiOperation(value = "文件上传")
    public FileUploadVO upload(@RequestBody @Validated FileUploadCmd cmd) {
        return fileService.upload(cmd);
       /* UploadSetting setting = uploadSettingService.getByCode(code);
        if(setting == null){
            return ResultUtil.error("找不到文件上传配置，请重试。");
        }
        if(StringUtils.isEmpty(mainId) && !setting.getCode().equals("file:file:other")){
            return ResultUtil.error("缺少参数表单id");
        }
        Integer maxSize = setting.getMaxSize();
        if (file.getSize() > maxSize * 1024 * 1024) {
            return ResultUtil.error("文件大小过大，不能超过" + maxSize + "MB");
        }
        if (StrUtil.isNotBlank(base64)) {
            // base64上传
            file = Base64DecodeMultipartFile.base64Convert(base64);
        }
        String url = "";
        String fKey = UploadUtil.renameFile(file.getOriginalFilename());
        File f = new File();
        try {
            InputStream inputStream = file.getInputStream();
            // 根据配置上传到指定地方
            url = fileManageFactory.getFileManage(setting.getLocation()).inputStreamUpload(inputStream, fKey, file,setting);
            // 保存数据信息至数据库
            f.setSettingId(setting.getId()).setName(file.getOriginalFilename()).setSize(file.getSize())
                    .setType(file.getContentType()).setFKey(fKey).setUrl(url).setMainId(mainId).setCatalogueId(setting.getCatalogueId());
            fileService.save(f);
        } catch (Exception e) {
            log.error(e.toString());
            return ResultUtil.error(e.toString());
        }
        if(setting.getLocation().equals(CommonConstant.FILE_UPLOAD_LOCATION_LOCAL)){
            url = "/api/xunheng-file/file/view/"+f.getId()+"/"+f.getFKey();
        }
        JSONObject fileResult = new JSONObject();
        fileResult.put("url",url);
        fileResult.put("id",f.getId());
        fileResult.put("fKey",f.getFKey());
        return ResultUtil.data(fileResult);*/
    }


    @PermissionCode("file.file.view")
    @Log(module = "文件",title = "文件本地查看", businessType = BusinessType.DETAIL)
    @RequestMapping(value = "/view/{id}/{fKey}", method = RequestMethod.GET)
    @ApiOperation(value = "文件本地查看")
    public void view(@PathVariable String id,HttpServletResponse response){
        fileService.view(id,response);
     /*   File file = fileService.getById(id);
        if (file == null) {
            throw new GlobalException("文件ID：" + id + "不存在");
        }
        String filename = file.getFKey();
        response.addHeader("Content-Disposition", "attachment; filename=" + URLEncoder.encode(filename, "UTF-8"));
        response.setContentLengthLong(file.getSize());
        response.setContentType(file.getType() + ";charset=UTF-8");
        response.addHeader("Accept-Ranges", "bytes");
        if (file.getSize() != null && file.getSize() > 0) {
            response.addHeader("Content-Range", "bytes " + 0 + "-" + (file.getSize() - 1) + "/" + file.getSize());
        }
        response.setBufferSize(10 * 1024 * 1024);
        LocalFileManage.view(file.getUrl(), response);*/
    }

}
