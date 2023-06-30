package com.xunheng.system.client.dto.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.util.Date;

@Data
public class TenantAuthRecordVO {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "授权日期")
    private Date authDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "授权到期日")
    private Date endDate;

    @ApiModelProperty(value = "租户名称")
    private String tenantName;
}
