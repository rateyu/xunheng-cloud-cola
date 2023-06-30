package com.xunheng.system.domain.dict.gateway;

import com.xunheng.system.domain.dict.model.DictEntity;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典网关
 * @author: hhqkkr
 * @date: 2023/6/29 23:46
 */
public interface DictGateway {

    /**
     * 获取所有字典
     * @return 字典列表
     */
    List<DictEntity> getAll();

    /**
     * 根据类型获取字典
     * @param type 字典类型
     * @return 字典信息
     */
    DictEntity getByType(String type);

    /**
     * 保存或更新字典信息
     * @param entity 字典实体
     * @return 字典实体
     */
    DictEntity saveOrUpdate(DictEntity entity);

    /**
     * 删除字典信息
     * @param id 字典id
     */
    void remove(String id);

    /**
     * 查询类型名称是否存在
     * @param type 类型名称
     * @param id 字典id
     * @return 是否
     */
    Boolean checkExist(String type,String id);

}
