package com.xunheng.system.client.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TenantAuthRecordSaveCmd {

    @ApiModelProperty(value = "id")
    private String id;

    @NotBlank(message = "租户id不能为空")
    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @NotNull(message = "授权日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "授权日期")
    private Date authDate;

    @NotNull(message = "授权到期日不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ApiModelProperty(value = "授权到期日")
    private Date endDate;

}