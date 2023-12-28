package com.xunheng.log.domain.log;

import com.alibaba.cola.domain.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.xunheng.base.utils.SnowFlakeUtil;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
public class LogEntity {


    @Schema(description = "操作id")
    private String id = String.valueOf(SnowFlakeUtil.nextId());

    @Schema(description = "功能模块")
    private String module;

    @Schema(description = "操作功能名称")
    private String title;

    @Schema(description = "业务类型")
    private String businessType;

    private String[] businessTypes;

    @Schema(description = "请求方法")
    private String method;

    @Schema(description = "请求方式")
    private String requestMethod;

    @Schema(description = "操作人员")
    private String operName;

    @Schema(description = "部门名称")
    private String departmentTitle;

    @Schema(description = "租户名称")
    private String tenantTitle;

    @Schema(description = "请求地址")
    private String operUrl;

    @Schema(description = "操作ip")
    private String operIp;

    @Schema(description = "请求参数")
    private String operParam;

    @Schema(description = "返回对象JSONString")
    private String resultStr;

    @Schema(description = "状态 0正常 1异常")
    private Integer status;

    @Schema(description = "错误消息")
    private String errorMsg;

    @Schema(description = "操作时间")
    private String operTime;

    @Schema(description = "时间戳 查询时间范围时使用")
    private Long operTimeMillis;
}
