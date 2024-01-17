package com.xunheng.system.app.executor.query;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.app.assembler.DictDataAssembler;
import com.xunheng.system.domain.dict.model.DictDataEntity;
import com.xunheng.system.client.dto.query.DictDataPageQuery;
import com.xunheng.system.client.dto.VO.DictDataVO;
import com.xunheng.system.domain.dict.gateway.DictDataGateway;
import org.springframework.stereotype.Component;

import jakarta.annotation.Resource;


/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据分页查询处理器
 * @author: hhqkkr
 * @date: 2023/6/29 22:40
 */
@Component
public class DictDataPageQueryExe {
    @Resource
    DictDataGateway dictDataGateway;

    public IPage<DictDataVO> execute(DictDataPageQuery query) {
        IPage<DictDataEntity> page = dictDataGateway.pageList(query);
        return page.convert(DictDataAssembler::toVo);
    }
}
