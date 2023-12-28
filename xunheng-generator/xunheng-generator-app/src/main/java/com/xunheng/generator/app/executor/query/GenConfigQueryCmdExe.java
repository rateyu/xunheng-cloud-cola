package com.xunheng.generator.app.executor.query;

import com.xunheng.generator.app.assembler.GenConfigAssembler;
import com.xunheng.generator.client.dto.VO.GenConfigVO;
import com.xunheng.generator.domain.genConfig.gateway.GenConfigGateway;
import com.xunheng.generator.domain.genConfig.gateway.GenFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.gateway.GenFrontFieldConfigGateway;
import com.xunheng.generator.domain.genConfig.model.GenConfigEntity;
import com.xunheng.generator.domain.genConfig.model.GenFieldConfigEntity;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 获取生成代码表格配置查询处理器
 * @author: hhqkkr
 * @date: 2023/7/3 16:59
 */
@Component
public class GenConfigQueryCmdExe {

    @Resource
    GenConfigGateway genConfigGateway;

    @Resource
    GenFieldConfigGateway genFieldConfigGateway;

    @Resource
    GenFrontFieldConfigGateway genFrontFieldConfigGateway;

    public GenConfigVO execute(){
        /*查询基础配置*/
        GenConfigEntity entity = genConfigGateway.getConfig();
        if(entity == null)return null;
        /*查询字段信息*/
        entity.setFieldList(genFieldConfigGateway.listAll());
        entity.setFrontFieldList(genFrontFieldConfigGateway.listAll());
        return GenConfigAssembler.toVo(entity);
    }
}
