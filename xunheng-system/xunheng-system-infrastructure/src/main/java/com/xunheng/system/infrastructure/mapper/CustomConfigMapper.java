package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunheng.system.infrastructure.DO.CustomConfig;
import org.springframework.stereotype.Repository;

/**
 * 自定义设置数据处理层
 * @author hhqkkr
 * @date 2022-05-10 17:28:03
 */
@Repository
public interface CustomConfigMapper extends BaseMapper<CustomConfig> {

}