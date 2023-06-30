package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.DictAssembler;
import com.xunheng.system.client.dto.VO.DictVO;
import com.xunheng.system.domain.dict.model.DictEntity;
import com.xunheng.system.domain.dict.gateway.DictGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;


/**
 * @program: xunheng-cloud-cola
 * @description: 字典信息查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:42
 */
@Component
public class DictListQueryExe {

    @Resource
    DictGateway dictGateway;

    public List<DictVO> execute() {
        List<DictEntity> list = dictGateway.getAll();
        return list.stream().map(DictAssembler::toVo).collect(Collectors.toList());
    }
}
