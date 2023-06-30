package com.xunheng.system.client.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import java.util.Date;

@Data
public class TenantSaveCmd {


    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "编号")
    private String code;

    @NotBlank(message = "租户名称不能为空")
    @ApiModelProperty(value = "租户名称")
    private String name;

    @NotBlank(message = "联系人姓名不能为空")
    @ApiModelProperty(value = "联系人姓名")
    private String contactor;

    @NotBlank(message = "联系电话不能为空")
    @ApiModelProperty(value = "联系电话")
    private String contact;

    @ApiModelProperty(value = "经营地址")
    private String address;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "授权到期日")
    private Date endDate;



}
