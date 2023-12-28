package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.CustomConfigAssembler;
import com.xunheng.system.client.dto.VO.CustomConfigVO;
import com.xunheng.system.domain.customConfig.model.CustomConfigEntity;
import com.xunheng.system.domain.customConfig.gateway.CustomConfigGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 系统拓展配置查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:58
 */
@Component
public class SystemConfigListQueryExe {
    @Resource
    CustomConfigGateway customConfigGateway;

    public List<CustomConfigVO> execute() {
        List<CustomConfigEntity> list = customConfigGateway.getSystemConfigList();
        return list.stream().map(CustomConfigAssembler::toVo).collect(Collectors.toList());
    }
}
