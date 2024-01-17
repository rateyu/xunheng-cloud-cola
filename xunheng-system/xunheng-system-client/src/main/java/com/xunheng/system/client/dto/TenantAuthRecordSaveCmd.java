package com.xunheng.system.client.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.util.Date;

@Data
public class TenantAuthRecordSaveCmd {

    @Schema(description = "id")
    private String id;

    @NotBlank(message = "租户id不能为空")
    @Schema(description = "租户id")
    private String tenantId;

    @NotNull(message = "授权日期不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "授权日期")
    private Date authDate;

    @NotNull(message = "授权到期日不能为空")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Schema(description = "授权到期日")
    private Date endDate;

}