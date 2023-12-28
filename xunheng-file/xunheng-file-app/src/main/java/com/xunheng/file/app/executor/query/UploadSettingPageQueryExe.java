package com.xunheng.file.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.file.app.assembler.UploadSettingAssembler;
import com.xunheng.file.client.dto.VO.UploadSettingVO;
import com.xunheng.file.client.dto.query.UploadSettingPageQuery;
import com.xunheng.file.domain.catalogue.ability.CatalogueDomainService;
import com.xunheng.file.domain.uploadSetting.gateway.UploadSettingGateway;
import com.xunheng.file.domain.uploadSetting.model.UploadSettingEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传设置分页查询处理器
 * @author: hhqkkr
 * @date: 2023/7/10 13:23
 */
@Component
public class UploadSettingPageQueryExe {

    @Resource
    UploadSettingGateway uploadSettingGateway;

    @Resource
    CatalogueDomainService catalogueDomainService;

    public IPage<UploadSettingVO> execute(UploadSettingPageQuery query){
        IPage<UploadSettingEntity> page = uploadSettingGateway.pageList(query);
        for (UploadSettingEntity entity : page.getRecords()) {
            entity.setFullDir(catalogueDomainService.getFullDirByCatalogueId(entity.getCatalogueId()));
        }
        return page.convert(UploadSettingAssembler::toVO);
    }
}
