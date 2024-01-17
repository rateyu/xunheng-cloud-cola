package com.xunheng.system.client.dto.VO;

import com.fasterxml.jackson.annotation.JsonFormat;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;

import java.util.Date;

@Data
public class TenantAuthRecordVO {

    @Schema(description = "id")
    private String id;

    @Schema(description = "租户id")
    private String tenantId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @Schema(description = "授权日期")
    private Date authDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @Schema(description = "授权到期日")
    private Date endDate;

    @Schema(description = "租户名称")
    private String tenantName;
}
