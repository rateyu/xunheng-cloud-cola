package com.xunheng.file.app.executor.query;

import com.xunheng.file.app.assembler.CatalogueAssembler;
import com.xunheng.file.client.dto.VO.CatalogueVO;
import com.xunheng.file.domain.catalogue.gateway.CatalogueGateway;
import com.xunheng.file.domain.catalogue.model.CatalogueEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 上传目录列表查询处理器
 * @author: hhqkkr
 * @date: 2023/7/10 12:55
 */
@Component
public class CatalogueListQueryExe {

    @Resource
    CatalogueGateway catalogueGateway;

    public List<CatalogueVO> execute(){
        List<CatalogueEntity> list = catalogueGateway.allList();
        return CatalogueAssembler.toTree(list.stream().map(CatalogueAssembler::toVo).collect(Collectors.toList()));
    }
}
