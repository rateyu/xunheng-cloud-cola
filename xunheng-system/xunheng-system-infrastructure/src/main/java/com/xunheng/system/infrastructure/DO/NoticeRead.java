package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.actable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * 系统信息已读
 * @author hhqkkr
 * @date 2022-04-29 12:23:58
 */
@Data
@TableName("sys_notice_read")
@ApiModel(value = "系统信息已读")
@Table
public class NoticeRead extends BaseDO {

    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "公告id")
    private String noticeId;

    @ApiModelProperty(value = "用户id")
    private String userId;

}