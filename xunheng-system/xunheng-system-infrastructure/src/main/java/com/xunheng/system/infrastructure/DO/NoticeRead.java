package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableName;
import com.tangzc.mpe.autotable.annotation.Table;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

/**
 * 系统信息已读
 * @author hhqkkr
 * @date 2022-04-29 12:23:58
 */
@Data
@TableName("sys_notice_read")
@Schema(description = "系统信息已读")
@Table
public class NoticeRead extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "公告id")
    private String noticeId;

    @Schema(description = "用户id")
    private String userId;

}