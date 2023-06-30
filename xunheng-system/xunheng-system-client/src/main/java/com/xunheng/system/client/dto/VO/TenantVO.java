package com.xunheng.system.client.dto.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TenantVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "编号")
    private String code;

    @ApiModelProperty(value = "租户名称")
    private String name;

    @ApiModelProperty(value = "联系人姓名")
    private String contactor;

    @ApiModelProperty(value = "联系电话")
    private String contact;

    @ApiModelProperty(value = "经营地址")
    private String address;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "授权到期日")
    private Date endDate;
}
