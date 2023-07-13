package com.xunheng.file.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.base.constant.CommonConstant;
import com.xunheng.file.app.assembler.FileAssembler;
import com.xunheng.file.app.assembler.UploadSettingAssembler;
import com.xunheng.file.client.dto.VO.FileVO;
import com.xunheng.file.client.dto.VO.UploadSettingVO;
import com.xunheng.file.client.dto.query.FilePageQuery;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;
import com.xunheng.file.domain.catalogue.ability.CatalogueDomainService;
import com.xunheng.file.domain.file.gateway.FileGateway;
import com.xunheng.file.domain.file.model.FileEntity;
import com.xunheng.file.domain.uploadSetting.gateway.UploadSettingGateway;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;
import com.xunheng.file.infrastructure.DO.File;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 文件分页查询处理器
 * @author: hhqkkr
 * @date: 2023/7/10 13:23
 */
@Component
public class FilePageQueryExe {

    @Resource
    FileGateway fileGateway;

    public IPage<FileVO> execute(FilePageQuery query){
        IPage<FileEntity> page = fileGateway.pageList(query);
        for (FileEntity entity : page.getRecords()) {
            /*如果是本地存储的文件，查看的地址要更改为查看接口的地址*/
            if(entity.getLocation().equals(CommonConstant.FILE_UPLOAD_LOCATION_LOCAL)){
                entity.setUrl("/api/xunheng-file/file/view/"+entity.getId()+"/"+entity.getFKey());
            }
        }
        return page.convert(FileAssembler::toVO);
    }
}
