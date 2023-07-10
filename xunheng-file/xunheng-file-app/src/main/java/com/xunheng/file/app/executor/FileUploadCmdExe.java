package com.xunheng.file.app.executor;


import com.xunheng.base.constant.CommonConstant;
import com.xunheng.base.exception.GlobalException;
import com.xunheng.file.client.dto.FileUploadCmd;
import com.xunheng.file.client.dto.VO.FileUploadVO;
import com.xunheng.file.domain.catalogue.ability.CatalogueDomainService;
import com.xunheng.file.domain.file.gateway.FileGateway;
import com.xunheng.file.domain.file.model.FileEntity;
import com.xunheng.file.domain.manage.FileManageFactory;
import com.xunheng.file.domain.uploadSetting.gateway.UploadSettingGateway;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;
import com.xunheng.file.infrastructure.utils.Base64DecodeMultipartFile;
import com.xunheng.file.infrastructure.utils.UploadUtil;
import io.seata.common.util.StringUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.Objects;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件上传操作处理器
 * @author: hhqkkr
 * @date: 2023/7/10 16:11
 */
@Component
@Slf4j
public class FileUploadCmdExe {

    @Resource
    FileGateway fileGateway;

    @Resource
    UploadSettingGateway uploadSettingGateway;

    @Resource
    CatalogueDomainService catalogueDomainService;

    @Resource
    FileManageFactory fileManageFactory;

    public FileUploadVO execute(FileUploadCmd cmd){
        /*根据上传码找到对应上传设置*/
        UploadSettingEntity setting = uploadSettingGateway.getByCode(cmd.getCode());
        if(setting == null)throw new GlobalException("找不到文件上传配置，请重试。");
        /*校验文件大小*/
        Integer maxSize = setting.getMaxSize();
        if (cmd.getFile().getSize() > maxSize * 1024 * 1024) throw new GlobalException("文件大小过大，不能超过" + maxSize + "MB");
        /*校验关联表单id 缺少mainId并且上传类型不是【其他上传】*/
        if(StringUtils.isEmpty(cmd.getMainId()) && !setting.getCode().equals("file:file:other")){
            throw new GlobalException("缺少参数表单id");
        }
        /*如果是base64 转换为file*/
        if (StringUtils.isNotBlank(cmd.getBase64())) {
           cmd.setFile(Base64DecodeMultipartFile.base64Convert(cmd.getBase64()));
        }
        /*生成文件key*/
        String fKey = UploadUtil.renameFile(Objects.requireNonNull(cmd.getFile().getOriginalFilename()));
        FileEntity entity = new FileEntity();
        String url = "";
        try {
            /*执行上传 根据配置的上传方式 上传到指定位置*/
            url = fileManageFactory.getFileManage(setting.getLocation()).inputStreamUpload(cmd.getFile().getInputStream(),cmd.getFile(),fKey,catalogueDomainService.getFullDirByCatalogueId(setting.getCatalogueId()));
            /*链式创建entity对象并保存*/
            entity.setSettingId(setting.getId()).setName(cmd.getFile().getOriginalFilename()).setSize(cmd.getFile().getSize())
                    .setType(cmd.getFile().getContentType()).setFKey(fKey).setUrl(url).setMainId(cmd.getMainId()).setCatalogueId(setting.getCatalogueId());
            entity = fileGateway.create(entity);
        } catch (Exception e) {
            log.error(e.toString());
            throw new GlobalException(e.toString());
        }
        /*如果上传方式是保存到本地的 url则改为文件查看地址返回到前端 前端才可以通过查看的api进行查看*/
        if(setting.getLocation().equals(CommonConstant.FILE_UPLOAD_LOCATION_LOCAL)){
            url = "/api/xunheng-file/file/view/"+entity.getId();
        }
        /*组装VO返回*/
        return new FileUploadVO(entity.getId(), entity.getFKey(),url);
    }
}
