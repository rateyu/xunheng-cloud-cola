package com.xunheng.system.domain.tenant.model;

import com.alibaba.cola.domain.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
public class TenantAuthRecordEntity {

    @Schema(description = "id")
    private String id;

    @Schema(description = "租户id")
    private String tenantId;

    @Schema(description = "授权日期")
    private Date authDate;

    @Schema(description = "授权到期日")
    private Date endDate;

    @Schema(description = "租户名称")
    private String tenantName;
}
