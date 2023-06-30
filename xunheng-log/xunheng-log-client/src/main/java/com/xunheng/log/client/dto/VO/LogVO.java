package com.xunheng.log.client.dto.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class LogVO {

    @ApiModelProperty(name = "操作id")
    private String id;

    @ApiModelProperty(name = "功能模块")
    private String module;

    @ApiModelProperty(name = "操作功能名称")
    private String title;

    @ApiModelProperty(name = "业务类型")
    private String businessType;

    @ApiModelProperty(name = "请求方法")
    private String method;

    @ApiModelProperty(name = "请求方式")
    private String requestMethod;

    @ApiModelProperty(name = "操作人员")
    private String operName;

    @ApiModelProperty(name = "部门名称")
    private String departmentTitle;

    @ApiModelProperty(name = "租户名称")
    private String tenantTitle;

    @ApiModelProperty(name = "请求地址")
    private String operUrl;

    @ApiModelProperty(name = "操作ip")
    private String operIp;

    @ApiModelProperty(name = "请求参数")
    private String operParam;

    @ApiModelProperty(name = "返回对象JSONString")
    private String resultStr;

    @ApiModelProperty(name = "状态 0正常 1异常")
    private Integer status;

    @ApiModelProperty(name = "错误消息")
    private String errorMsg;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "操作时间")
    private Date operTime;

    @ApiModelProperty(value = "时间戳 查询时间范围时使用")
    private Long operTimeMillis;
}
