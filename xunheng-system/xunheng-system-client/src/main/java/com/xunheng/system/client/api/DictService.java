package com.xunheng.system.client.api;

import com.xunheng.system.client.dto.DictSaveCmd;
import com.xunheng.system.client.dto.VO.DictVO;

import java.util.List;

/**
 * @program: xunheng-cloud-cola
 * @description: 字典service接口
 * @author: hhqkkr
 * @date: 2023/6/29 19:04
 */
public interface DictService {

    /**
     * 获取所有字典
     */
    List<DictVO> getAll();

    /**
     * 保存或更新字典信息
     * @param cmd 保存操作dto
     * @return 字典vo
     */
    DictVO saveOrUpdate(DictSaveCmd cmd);

    /**
     * 字典删除
     * @param id 字典id
     */
    void remove(String id);

}