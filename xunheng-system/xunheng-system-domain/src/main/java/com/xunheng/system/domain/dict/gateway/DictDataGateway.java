package com.xunheng.system.domain.dict.gateway;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.domain.dict.model.DictDataEntity;
import com.xunheng.system.client.dto.query.DictDataPageQuery;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:43
 */
public interface DictDataGateway {

    /**
     * 字典数据分页列表
     * @param query 查询条件dto
     * @return 分页列表
     */
    IPage<DictDataEntity> pageList(DictDataPageQuery query);

    /**
     * 根据字典类型获取字典数据
     * @param dictId 字典类型
     * @return 字典数据列
     */
    List<DictDataEntity> getByDictId(String dictId);

    /**
     * 保存或更新字典数据
     * @param entity 字典数据实体
     * @return 字典数据实体
     */
    DictDataEntity saveOrUpdate(DictDataEntity entity);

    /**
     * 根据字典id删除字典数据
     * @param dictId 字典id
     */
    void removeByDictId(String dictId);

    /**
     * 删除字典数据
     * @param id 字典数据id
     */
    void remove(String id);

    /**
     * 更新字典数据类型
     * @param id 字典id
     * @param status 更新状态
     */
    void updateStatus(String id,Integer status);

}
