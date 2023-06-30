package com.xunheng.system.client.api;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.xunheng.system.client.dto.DictDataSaveCmd;
import com.xunheng.system.client.dto.VO.DictDataVO;
import com.xunheng.system.client.dto.query.DictDataPageQuery;
import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典数据service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:02
 */
public interface DictDataService {

    /**
     * 字典数据分页列表
     * @param query 查询dto
     * @return 分页列表
     */
    IPage<DictDataVO> pageList(DictDataPageQuery query);

    /**
     * 根据字典类型获取数据集合
     * @param type 字典类型
     * @return 字典数据集合
     */
    List<DictDataVO> getByDictType(String type);

    /**
     * 保存或更新字典数据
     * @param cmd 保存操作dto
     * @return 字典数据vo
     */
    DictDataVO saveOrUpdate(DictDataSaveCmd cmd);

    /**
     * 更新字典数据状态
     * @param id 字典数据id
     * @param status 状态类型
     */
    void updateDictStatus(String id, Integer status);

    /**
     * 删除字典数据
     * @param id 字典数据id
     */
    void remove(String id);


}