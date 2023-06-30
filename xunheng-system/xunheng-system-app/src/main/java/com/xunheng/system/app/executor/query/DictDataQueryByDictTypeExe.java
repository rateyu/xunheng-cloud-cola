package com.xunheng.system.app.executor.query;

import com.xunheng.system.app.assembler.DictDataAssembler;
import com.xunheng.system.domain.dict.model.DictEntity;
import com.xunheng.system.domain.dict.model.DictDataEntity;
import com.xunheng.system.client.dto.VO.DictDataVO;
import com.xunheng.system.domain.dict.gateway.DictDataGateway;
import com.xunheng.system.domain.dict.gateway.DictGateway;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @program: xunheng-cloud-cola
 * @description: 根据字典类型查询字典数据处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:40
 */
@Component
public class DictDataQueryByDictTypeExe {
    @Resource
    DictDataGateway dictDataGateway;

    @Resource
    DictGateway dictGateway;

    public List<DictDataVO> execute(String dictType) {
        /*根据类型找到字典信息*/
        DictEntity dict = dictGateway.getByType(dictType);
        /*查询对应的字典数据*/
        List<DictDataEntity> list = dictDataGateway.getByDictId(dict.getId());
        return list.stream().map(DictDataAssembler::toVo).collect(Collectors.toList());
    }
}
