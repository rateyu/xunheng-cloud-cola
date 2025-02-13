package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.ColumnType;
import com.tangzc.mpe.autotable.annotation.Table;
import com.tangzc.mpe.autotable.strategy.mysql.data.MysqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 自定义设置
 * @author hhqkkr
 * @date 2022-05-10 17:28:03
 */
@Data
@TableName("sys_feedback")
@Schema(description = "意见反馈")
@Table
public class Feedback extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ColumnType(MysqlTypeConstant.TEXT)
    @Schema(description = "内容")
    private String content;

}