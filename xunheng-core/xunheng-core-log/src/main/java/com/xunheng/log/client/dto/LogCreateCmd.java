package com.xunheng.log.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.xunheng.base.utils.SnowFlakeUtil;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @program: xunheng-cloud-cola
 * @description: 日志新增操作
 * @author: hhqkkr
 * @create: 2021-12-24 16:09
 */
@Data
public class LogCreateCmd {

    @ApiModelProperty(name = "操作id")
    private String id = String.valueOf(SnowFlakeUtil.nextId());

    @ApiModelProperty(name = "功能模块")
    private String module;

    @ApiModelProperty(name = "操作功能名称")
    private String title;

    @ApiModelProperty(name = "业务类型")
    private String businessType;

    private String[] businessTypes;

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

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @ApiModelProperty(name = "操作时间")
    private Date operTime = new Date();

    @ApiModelProperty(value = "时间戳 查询时间范围时使用")
    private Long operTimeMillis = System.currentTimeMillis();
}
