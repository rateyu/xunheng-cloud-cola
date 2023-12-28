package com.xunheng.system.infrastructure.DO;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.tangzc.mpe.actable.annotation.ColumnType;
import com.tangzc.mpe.actable.annotation.Table;
import com.tangzc.mpe.actable.annotation.constants.MySqlTypeConstant;
import com.xunheng.datasource.infrastructure.DO.BaseDO;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * @author hhqkkr
 */
@Data
@TableName("sys_tenant_auth_record")
@Schema(description = "租户授权")
@Table
public class TenantAuthRecord extends BaseDO {

    private static final long serialVersionUID = 1L;

    @Schema(description = "租户id")
    private String tenantId;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnType(MySqlTypeConstant.DATE)
    @Schema(description = "授权日期")
    private Date authDate;

    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @ColumnType(MySqlTypeConstant.DATE)
    @Schema(description = "授权到期日")
    private Date endDate;

    @TableField(exist=false)
    @Schema(description = "租户名称")
    private String tenantName;

}