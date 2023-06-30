package com.xunheng.system.domain.tenant.model;

import com.alibaba.cola.domain.Entity;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
@Entity
public class TenantAuthRecordEntity {

    @ApiModelProperty(value = "id")
    private String id;

    @ApiModelProperty(value = "租户id")
    private String tenantId;

    @ApiModelProperty(value = "授权日期")
    private Date authDate;

    @ApiModelProperty(value = "授权到期日")
    private Date endDate;

    @ApiModelProperty(value = "租户名称")
    private String tenantName;
}
