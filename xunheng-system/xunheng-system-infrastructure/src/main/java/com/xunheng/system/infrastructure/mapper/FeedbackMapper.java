package com.xunheng.system.infrastructure.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.xunheng.system.infrastructure.DO.Feedback;
import org.springframework.stereotype.Repository;

/**
 * 意见反馈数据处理层
 * @author hhqkkr
 * @date 2022-05-10 17:28:03
 */
@Repository
public interface FeedbackMapper extends BaseMapper<Feedback> {

}